package com.souljit2.selleverything.global.handler;

import com.souljit2.selleverything.global.exception.AuthenticationFailedException;
import com.souljit2.selleverything.domain.member.controller.AuthController;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = {AuthController.class})
public class AuthExceptionHandlers {

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleDuplicateKeyException() {
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleAuthenticationFailedException() {
    }
}
