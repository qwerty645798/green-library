package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
    @NotNull
    private String adminId;
    private String adminName;
    private String adminPass;
    private String adminEmail;

    @NotNull
    private Integer grantRank;

}