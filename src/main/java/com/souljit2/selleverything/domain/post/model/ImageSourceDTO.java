package com.souljit2.selleverything.domain.post.model;

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
public class ImageSourceDTO {

    private int id;

    @NonNull
    @NotBlank
    @Size(max = 200)
    private String imageSource;

    @NonNull
    @Min(1)
    private int postIdFk;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
