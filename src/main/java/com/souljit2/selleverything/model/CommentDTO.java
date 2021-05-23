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
public class CommentDTO {

    @NonNull
    @Min(0)
    private int memberIdFk;

    @NonNull
    @Min(0)
    private int postIdFk;

    @NonNull
    @NotBlank
    @Size(max = 200)
    private String commentContents;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
