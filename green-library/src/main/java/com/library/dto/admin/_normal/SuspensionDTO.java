package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SuspensionDTO {
    @NotNull
    private Long suspensionId;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    private String reason;
    @NotNull
    private String userId;
}

