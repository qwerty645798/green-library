package com.library.entity;

import java.util.Date;

public class Inquiry_responses {
    private Long response_id;
    private Long inquiry_id;
    private Date response_date;
    private String response_content;
    private String admin_id;
	public Long getResponse_id() {
		return response_id;
	}
	public void setResponse_id(Long response_id) {
		this.response_id = response_id;
	}
	public Long getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(Long inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	public Date getResponse_date() {
		return response_date;
	}
	public void setResponse_date(Date response_date) {
		this.response_date = response_date;
	}
	public String getResponse_content() {
		return response_content;
	}
	public void setResponse_content(String response_content) {
		this.response_content = response_content;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
}