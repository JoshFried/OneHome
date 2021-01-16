package com.htne.helpthehomeless.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponseDTO {
    private final String  token;
    private final UserDTO user;
}