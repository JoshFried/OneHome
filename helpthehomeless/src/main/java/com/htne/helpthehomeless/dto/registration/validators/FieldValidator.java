package com.htne.helpthehomeless.dto.registration.validators.annotations;

public final class FieldValidator {
    private FieldValidator() { }

    public static void validateField(final String field, final String fieldName) {
        if (field.isEmpty()) {
            final String errorMsg = String.format("Invalid field: %field cannot be empty", fieldName);
            throw new InvalidFieldException(errorMsg);
        }
    }
}