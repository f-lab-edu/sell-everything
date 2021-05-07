package com.souljit2.selleverything.handler;

import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.utils.Responses;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity handleDuplicateKeyException() {
        return Responses.CONFLICT;
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity handleAuthenticationFailedException() {
        return Responses.UNAUTHORIZED;
    }
}
