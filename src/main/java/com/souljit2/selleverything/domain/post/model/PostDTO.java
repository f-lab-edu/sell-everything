package com.souljit2.selleverything.domain.post.model;

import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @NonNull
    @Min(1)
    private int memberIdFk;

    @NonNull
    @Min(0)
    private int likeCount;

    @NonNull
    @Min(0)
    private int commentCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}