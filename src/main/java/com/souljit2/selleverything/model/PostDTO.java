package com.souljit2.selleverything.model;

import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class PostDTO {

    @NonNull
    private int id;

    @NonNull
    @Min(1)
    private int memberIdFk;

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

    private enum PostCategory {
        CLOTHES,
        INSTRUMENTS,
        VEHICLES,
        PHONES,
        ACCESSORIES,
        PROPS,
        ETCS
    }

}