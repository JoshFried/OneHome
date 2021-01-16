package com.htne.helpthehomeless.dto.registration.validators.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends RuntimeException {
    private static final long serialVersionUID = -8917467230333493647L;

    public InvalidFieldException(final String msg) {
        super(msg);
    }
}