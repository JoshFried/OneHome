package com.htne.helpthehomeless.controllers;

import com.htne.helpthehomeless.dal.service.UserService;
import com.htne.helpthehomeless.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @PutMapping(path = "/update")
    public ResponseEntity<UserDTO> updateUserLocation(@AuthenticationPrincipal @RequestBody final Authentication authentication, final UserDTO user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable final String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "/logout")
    public ResponseEntity<String> logoutUser() {
        return new ResponseEntity<>("USER SUCCESSFULLY LOGGED OUT AND CLOSED THE SIMULATION", HttpStatus.ACCEPTED);
    }

    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserDTO> getAuthenticatedUser(@AuthenticationPrincipal final Authentication authentication) {
        return new ResponseEntity<>(userService.getUserByUsername(authentication.getName()), HttpStatus.ACCEPTED);
    }

}