package com.library.dto.user;

import java.sql.Date;

public class My_InquiryDto {
	
	private int inquiryId;
	private String userId;
	private Date inquiryDate;
	private String inquiryTitle;
	private String responserTF;
	
	public int getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public String getInquiryTitle() {
		return inquiryTitle;
	}
	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}
	public String getResponserTF() {
		return responserTF;
	}
	public void setResponserTF(String responserTF) {
		this.responserTF = responserTF;
	}
	
	
	
}
