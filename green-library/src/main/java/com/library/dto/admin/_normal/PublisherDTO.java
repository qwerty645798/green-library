package com.library.dto.admin._normal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Valid
public class PublisherDTO {
    @NotNull
    private Long publisherId;
    private String publisherName;
}
