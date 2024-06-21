package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationDTO {
    @NotNull
    private Long reservationId;
    @NotNull
    private String userId;
    @NotNull
    private Long bookId;
    private Date reservationDate;
}

