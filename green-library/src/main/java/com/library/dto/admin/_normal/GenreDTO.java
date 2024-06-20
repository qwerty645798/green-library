package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {
    @NotNull
    private String genreId;
    private String genreName;
}
