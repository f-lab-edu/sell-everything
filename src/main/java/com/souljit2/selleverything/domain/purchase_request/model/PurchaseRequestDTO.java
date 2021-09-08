package com.souljit2.selleverything.domain.purchase_request.model;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class PurchaseRequestDTO {

    @NonNull
    @Min(1)
    private int postIdFk;

    @NonNull
    @Min(1)
    private int memberIdFk;

}
