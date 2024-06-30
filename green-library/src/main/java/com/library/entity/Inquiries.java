package com.library.entity;

public class Inquiries {
    private Long inquiry_id;
    private String inquiry_title;
    private String contents;
    private String user_id;
	public Long getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(Long inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	public String getInquiry_title() {
		return inquiry_title;
	}
	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}