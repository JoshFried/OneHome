package com.htne.helpthehomeless.controllers;

import com.htne.helpthehomeless.dal.service.AuthenticationService;
import com.htne.helpthehomeless.dto.UserDTO;
import com.htne.helpthehomeless.dto.login.LoginRequestDTO;
import com.htne.helpthehomeless.dto.login.LoginResponseDTO;
import com.htne.helpthehomeless.dto.registration.UserRegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(path = "/register")
    public ResponseEntity<UserDTO> addNewUser(final HttpServletRequest request, @RequestBody final UserRegistrationDTO userRegistrationDTO) {
        return new ResponseEntity<>(authenticationService.registerUser(userRegistrationDTO), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponseDTO> loginUser(final HttpServletRequest request, @RequestBody final LoginRequestDTO loginRequest) {
        return new ResponseEntity<>(authenticationService.login(request, loginRequest), HttpStatus.OK);
    }

    @PostMapping(path = "/confirm-account")
    public ResponseEntity<UserDTO> confirmAccount(@RequestParam final String token) {
        return new ResponseEntity<>(authenticationService.confirmUserAccount(token), HttpStatus.ACCEPTED);
    }

}