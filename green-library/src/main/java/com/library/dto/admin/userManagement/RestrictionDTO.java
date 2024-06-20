package com.library.dto.admin.userManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class RestrictionDTO {
    private int userID;
    private int suspensionID;
    private String suspensionReason;
    private Date suspensionStart;
    private Date suspensionEnd;

}
