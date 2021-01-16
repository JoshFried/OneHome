package com.htne.helpthehomeless.dto.registration;

import com.htne.helpthehomeless.dto.registration.validators.annotations.PasswordMatches;
import com.htne.helpthehomeless.dto.registration.validators.annotations.ValidEmail;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@PasswordMatches
@ValidEmail
public class RegistrationDTO {
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String matchingPassword;
}