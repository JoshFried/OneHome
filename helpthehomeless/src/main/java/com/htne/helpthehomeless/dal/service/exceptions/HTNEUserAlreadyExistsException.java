package com.htne.helpthehomeless.dal.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HTNEUserAlreadyExistsException extends RuntimeException {
    public HTNEUserAlreadyExistsException(final String msg) {super(msg);}
}
