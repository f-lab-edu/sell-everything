package com.souljit2.selleverything.domain.comment.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentVO {

    private int memberIdFk;

    private String memberNickname;

    private String commentContents;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
