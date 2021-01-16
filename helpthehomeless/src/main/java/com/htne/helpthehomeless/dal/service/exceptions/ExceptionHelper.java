package com.htne.helpthehomeless.dal.service.service;

public final class ExceptionHelper {
    private ExceptionHelper() {
    }

    public static String getNotFoundExceptionMessage(final String field, final String parameter) {
        return String.format("%s: %s doesn't exist", field, parameter);
    }
}
