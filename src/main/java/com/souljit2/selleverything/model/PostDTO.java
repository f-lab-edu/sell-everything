package com.souljit2.selleverything.model;

import com.souljit2.selleverything.post.PostCategory;

import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class PostDTO {

    @NonNull
    private int id;


    @NonNull
    @NotBlank
    @Size(max = 45)
    private String postTitle;

    @NonNull
    @NotBlank
    @Size(max = 300)
    private String postContents;

    @NonNull
    private int postItemPrice;

    @NonNull
    @NotBlank
    @Size(max = 45)
    private String postItemName;

    @NonNull
    private PostCategory postCategory;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NonNull
    @Min(1)
    private int memberIdFk;

}