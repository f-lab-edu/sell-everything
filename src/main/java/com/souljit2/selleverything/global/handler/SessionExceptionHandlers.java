package com.souljit2.selleverything.global.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SessionExceptionHandlers {

    @ExceptionHandler(HttpSessionRequiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleHttpSessionRequiredException() {
    }

}
