package com.htne.helpthehomeless.dal.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HTNENotFoundException extends RuntimeException {
    public HTNENotFoundException(final String msg) {super(msg);}
}
