package com.souljit2.selleverything.domain.comment.model;

import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class CommentDTO {

    @NonNull
    @Min(1)
    private int memberIdFk;

    @NonNull
    @Min(1)
    private int postIdFk;

    @NonNull
    @NotBlank
    @Size(max = 200)
    private String commentContents;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
