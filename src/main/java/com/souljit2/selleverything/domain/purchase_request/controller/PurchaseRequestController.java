package com.souljit2.selleverything.domain.purchase_request.controller;

import com.souljit2.selleverything.domain.purchase_request.service.PurchaseRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/purchase-request")
public class PurchaseRequestController {

    private PurchaseRequestService purchaseRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPurchaseRequest(@RequestParam int postId) {
        purchaseRequestService.createPurchaseRequest(postId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePurchaseRequestById(@PathVariable int id) {
        purchaseRequestService.deletePurchaseRequestById(id);
    }
}
