package com.souljit2.selleverything.domain.payment_request.service;

import com.souljit2.selleverything.domain.member.service.AuthService;
import com.souljit2.selleverything.domain.payment_request.mapper.PaymentRequestMapper;
import com.souljit2.selleverything.domain.payment_request.model.PaymentRequestDTO;
import com.souljit2.selleverything.global.constants.CacheNames;
import java.sql.SQLIntegrityConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentRequestServiceImpl implements PaymentRequestService {

    private PaymentRequestMapper paymentRequestMapper;
    private AuthService authService;

    @Override
    @CacheEvict(value = CacheNames.POST)
    public void createPaymentRequest(int postId) {
        int memberId = authService.getRequestMemberId();
        try {
            paymentRequestMapper.insertPurchaseRequest(
                new PaymentRequestDTO(
                    postId,
                    memberId
                )
            );
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new DuplicateKeyException(
                "A purchase request for this product already exists.",
                ex
            );
        }
    }

    @Override
    @CacheEvict(value = CacheNames.POST)
    public void deletePurchaseRequestById(int id) {
        paymentRequestMapper.deletePurchaseRequestById(id);
    }
}
