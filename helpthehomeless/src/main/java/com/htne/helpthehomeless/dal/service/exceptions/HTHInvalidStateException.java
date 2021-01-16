package com.htne.helpthehomeless.dal.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HTHInvalidStateException extends RuntimeException {
    public HTHInvalidStateException(final String msg) {super(msg);}
}
