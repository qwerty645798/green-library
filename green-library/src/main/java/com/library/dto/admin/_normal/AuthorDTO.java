package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorDTO {
    @NotNull
    private Long authorId;
    @NotNull
    private String authorName;

}
