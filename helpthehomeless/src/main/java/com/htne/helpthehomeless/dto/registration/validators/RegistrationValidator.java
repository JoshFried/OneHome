package com.htne.helpthehomeless.dto.registration.validators;

import com.htne.helpthehomeless.dto.registration.UserRegistrationDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegistrationValidator {

    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME  = "last name";
    private static final String USERNAME   = "Username";

    public static void validateRegistration(final UserRegistrationDTO dto) {
        FieldValidator.validateField(dto.getFirstName(), FIRST_NAME);
        FieldValidator.validateField(dto.getLastName(), LAST_NAME);
        FieldValidator.validateField(dto.getUsername(), USERNAME);
    }
}