package com.souljit2.selleverything.domain.payment_request.controller;

import com.souljit2.selleverything.domain.payment_request.service.PaymentRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/payment-request")
public class PaymentRequestController {

    private PaymentRequestService paymentRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPaymentRequest(@RequestParam int postId) {
        paymentRequestService.createPaymentRequest(postId);
    }
}
