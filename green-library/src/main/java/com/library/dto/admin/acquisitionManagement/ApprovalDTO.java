package com.library.dto.admin.acquisitionManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class ApprovalDTO {
    private int wishlistID;
    private String wishTitle;

    private String wishAuthor;
    private String wishPublisher;
    private Date wishDate;

    private String wishPrice;

}
