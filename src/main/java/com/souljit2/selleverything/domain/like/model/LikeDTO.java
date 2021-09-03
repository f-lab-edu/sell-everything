package com.souljit2.selleverything.domain.like.model;

import java.time.LocalDateTime;
import javax.validation.constraints.Min;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class LikeDTO {

    @NonNull
    @Min(1)
    private int likeId;

    @NonNull
    @Min(1)
    private int memberIdFk;

    @NonNull
    @Min(1)
    private int postIdFk;

    @NonNull
    private boolean likeYn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
