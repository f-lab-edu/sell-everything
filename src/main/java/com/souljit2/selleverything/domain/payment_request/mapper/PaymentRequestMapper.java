package com.souljit2.selleverything.domain.payment_request.mapper;

import com.souljit2.selleverything.domain.payment_request.model.PaymentRequestDTO;
import java.sql.SQLIntegrityConstraintViolationException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentRequestMapper {

    public void insertPurchaseRequest(PaymentRequestDTO paymentRequest)
        throws SQLIntegrityConstraintViolationException;

    public void deletePurchaseRequestById(int id);

}
