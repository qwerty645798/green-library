package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WaitlistDTO {
    @NotNull
    private Integer waitlistId;
    @NotNull
    private Integer bookId;
    @NotNull
    private String userId;

    private Date waitlistDate;
}

