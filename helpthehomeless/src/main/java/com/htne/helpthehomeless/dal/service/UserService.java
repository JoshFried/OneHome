package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.dao.UserRepository;
import com.htne.helpthehomeless.dal.dao.mapper.UserMapper;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.exceptions.ExceptionHelper;
import com.htne.helpthehomeless.dal.service.exceptions.HTNENotFoundException;
import com.htne.helpthehomeless.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ConversionService mvcConversionService;
    private final UserRepository    userRepository;

    public UserDTO createUser(final User user) {
        return mvcConversionService.convert(userRepository.save(user), UserDTO.class);
    }

    public UserDTO getUserByUsername(final String username) {
        return mvcConversionService.convert(fetchByUsername(username), UserDTO.class);
    }

    public boolean usernameExists(final String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean emailExists(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User getUserFromContext() {
        final UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return fetchByUsername(details.getUsername());
    }

    public User fetchByUsername(final String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Username", username)));
    }

    public UserDTO updateUser(final UserDTO user) {
        return mvcConversionService.convert(userRepository.save(UserMapper.mapStringFields(user, fetchById(user.getId()))), UserDTO.class);
    }

    private User fetchById(final long id) {
        return userRepository.findById(id).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("id", String.valueOf(id))));
    }

    public UserDTO toggleAccountActivation(final User user) {
        user.setEnabled(!user.isEnabled());
        return mvcConversionService.convert(userRepository.save(user), UserDTO.class);
    }
}