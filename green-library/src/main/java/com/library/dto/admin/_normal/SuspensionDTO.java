package com.library.dto.admin._normal;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SuspensionDTO {
    private int suspensionId;
    private Date startDate;
    private Date endDate;
    private int duration;
    private String reason;
    private String userId;

}

