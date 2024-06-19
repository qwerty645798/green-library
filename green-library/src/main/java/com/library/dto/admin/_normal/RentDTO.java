package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RentDTO {
    @NotNull
    private Long rentNum;
    private Date rentHistory;
    @NotNull
    private Long bookId;
    @NotNull
    private String userId;
    @NotNull
    private Character returned;
}

