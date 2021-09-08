package com.souljit2.selleverything.domain.purchase_request.mapper;

import com.souljit2.selleverything.domain.purchase_request.model.PurchaseRequestDTO;
import java.sql.SQLIntegrityConstraintViolationException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRequestMapper {

    public void insertPurchaseRequest(PurchaseRequestDTO purchaseRequestDTO)
        throws SQLIntegrityConstraintViolationException;

    public void deletePurchaseRequestById(int id);

}
