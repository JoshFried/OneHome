package com.htne.helpthehomeless.dto.login;

import com.htne.helpthehomeless.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponseDTO {
    private final String  token;
    private final UserDTO user;
}