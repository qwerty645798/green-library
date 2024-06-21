package com.library.entity;

import java.util.Date;

public class Suspensions {
    private Long suspension_id;
    private Date start_date;
    private Date end_date;
    private String reason;
    private String user_id;
	public Long getSuspension_id() {
		return suspension_id;
	}
	public void setSuspension_id(Long suspension_id) {
		this.suspension_id = suspension_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}