package com.htne.helpthehomeless.dto.registration.validators;


import com.htne.helpthehomeless.dto.registration.UserRegistrationDTO;
import com.htne.helpthehomeless.dto.registration.validators.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(final Object o, final ConstraintValidatorContext constraintValidatorContext) {
        final UserRegistrationDTO userRegistrationDTO = (UserRegistrationDTO) o;
        return userRegistrationDTO.getPassword().equals(userRegistrationDTO.getMatchingPassword());
    }

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }
}