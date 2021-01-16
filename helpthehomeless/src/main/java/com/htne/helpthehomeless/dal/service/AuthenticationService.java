package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.dao.ConfirmationTokenRepository;
import com.htne.helpthehomeless.dal.model.ConfirmationToken;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.exceptions.ExceptionHelper;
import com.htne.helpthehomeless.dal.service.exceptions.HTNENotFoundException;
import com.htne.helpthehomeless.dal.service.exceptions.HTNEUserAlreadyExistsException;
import com.htne.helpthehomeless.dto.UserDTO;
import com.htne.helpthehomeless.dto.login.LoginRequestDTO;
import com.htne.helpthehomeless.dto.login.LoginResponseDTO;
import com.htne.helpthehomeless.dto.registration.UserRegistrationDTO;
import com.htne.helpthehomeless.dto.registration.validators.RegistrationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final ConversionService           mvcConversionService;
    private final PasswordEncoder             passwordEncoder;
    private final AuthenticationProvider      authenticationProvider;
    private final UserService                 userService;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailService                emailService;
    public static final String USER_ALREADY_EXISTS_ERROR_MESSAGE = "Username/email already exists";

    public UserDTO registerUser(final UserRegistrationDTO registration) {
        if (userService.emailExists(registration.getEmail()) || userService.usernameExists(registration.getUsername())) {
            throw new HTNEUserAlreadyExistsException(USER_ALREADY_EXISTS_ERROR_MESSAGE);
        }
        RegistrationValidator.validateRegistration(registration);

        final User user = mvcConversionService.convert(registration, User.class);
        Objects.requireNonNull(user).setPassword(passwordEncoder.encode(registration.getPassword()));

        confirmationTokenRepository.save(emailService.createAndSendEmailConfirmation(user));
        return userService.createUser(user);
    }

    public LoginResponseDTO login(final HttpServletRequest request, final LoginRequestDTO loginRequest) {
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                                                                                                                loginRequest.getPassword());
        authenticationProvider.authenticate(authenticationToken);
        final SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authenticationToken);

        final HttpSession session = request.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, securityContext);

        return LoginResponseDTO.builder()
                               .token(session.getId())
                               .user(userService.getUserByUsername(loginRequest.getUsername()))
                               .build();
    }

    public UserDTO confirmUserAccount(final String token) {
        final ConfirmationToken confirmationToken = confirmationTokenRepository.findByConfirmationToken(token);

        if (confirmationToken == null) {
            throw new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Token", token));
        }

        return userService.toggleAccountActivation(confirmationToken.getUser());
    }
}
