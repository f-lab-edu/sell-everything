package com.souljit2.selleverything.domain.purchase_request.service;

import com.souljit2.selleverything.domain.member.service.AuthService;
import com.souljit2.selleverything.domain.purchase_request.mapper.PurchaseRequestMapper;
import com.souljit2.selleverything.domain.purchase_request.model.PurchaseRequestDTO;
import com.souljit2.selleverything.global.constants.CacheNames;
import java.sql.SQLIntegrityConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseRequestServiceImpl implements PurchaseRequestService {

    private PurchaseRequestMapper purchaseRequestMapper;
    private AuthService authService;

    @Override
    @CacheEvict(value = CacheNames.POST)
    public void createPurchaseRequest(int postId) {
        int memberId = authService.getRequestMemberId();
        try {
            purchaseRequestMapper.insertPurchaseRequest(
                new PurchaseRequestDTO(
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
        purchaseRequestMapper.deletePurchaseRequestById(id);
    }
}
