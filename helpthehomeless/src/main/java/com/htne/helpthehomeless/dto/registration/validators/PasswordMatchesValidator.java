package com.htne.helpthehomeless.dto.registration.validators;


import com.htne.helpthehomeless.dto.registration.RegistrationDTO;
import com.htne.helpthehomeless.dto.registration.validators.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(final Object o, final ConstraintValidatorContext constraintValidatorContext) {
        final RegistrationDTO registrationDTO = (RegistrationDTO) o;
        return registrationDTO.getPassword().equals(registrationDTO.getMatchingPassword());
    }

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }
}