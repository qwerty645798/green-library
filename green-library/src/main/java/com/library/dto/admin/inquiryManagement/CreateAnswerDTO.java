package com.library.dto.admin.inquiryManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class CreateAnswerDTO {
    private int inquiryID;
    private String inquiryTitle;
    private String inquiryContents;

    private int userID;
    private Date inquiryDate;

//    writing
    private int responseID;
    private String adminID;
    private Date responseDate;
    private String responseContents;

}
