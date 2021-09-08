package com.souljit2.selleverything.global.handler;

import com.souljit2.selleverything.domain.purchase_request.controller.PurchaseRequestController;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = {PurchaseRequestController.class})
public class PurchaseRequestExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleDuplicateKeyException() {
    }
}
