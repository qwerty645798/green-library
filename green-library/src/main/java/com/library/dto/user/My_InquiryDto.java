package com.library.dto.user;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class My_InquiryDto {
	
	private int inquiryId;
	private String userId;
	private Date inquiryDate;
	private String inquiryTitle;
	private String responserTF;
	
}
