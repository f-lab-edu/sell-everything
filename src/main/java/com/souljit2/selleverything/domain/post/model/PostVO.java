package com.souljit2.selleverything.domain.post.model;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@AllArgsConstructor
public class PostVO {

    private int id;

    private String postTitle;

    private String postContents;

    private int postItemPrice;

    private String postItemName;

    private PostCategory postCategory;

    private int memberIdFk;

    private int likeCount;

    private int commentCount;

    private Integer buyerId;

    private String buyerNickname;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}