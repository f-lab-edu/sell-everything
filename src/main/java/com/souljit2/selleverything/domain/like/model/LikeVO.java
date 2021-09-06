package com.souljit2.selleverything.domain.like.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeVO {

    private String memberName;

    private String memberNickname;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
