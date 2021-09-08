package com.souljit2.selleverything.global.handler;

import com.souljit2.selleverything.domain.payment_request.controller.PaymentRequestController;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = {PaymentRequestController.class})
public class PaymentRequestExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleDuplicateKeyException() {
    }
}
