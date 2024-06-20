package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminGrantDTO {
    @NotNull
    private Integer grantRank;
    private String grantName;
}
