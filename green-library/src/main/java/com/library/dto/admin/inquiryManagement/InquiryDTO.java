package com.library.dto.admin.inquiryManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class InquiryDTO {
    private int inquiryID;
    private String inquiryTitle;
    private String inquiryContents;

    private int userID;
    private Date inquiryDate;
    private String responseTF;
}
