package com.library.entity;

public class Admins {
    private String admin_id;
    private String admin_name;
    private String admin_pass;
    private String admin_email;
    private Integer grant_rank;
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_pass() {
		return admin_pass;
	}
	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public Integer getGrant_rank() {
		return grant_rank;
	}
	public void setGrant_rank(Integer grant_rank) {
		this.grant_rank = grant_rank;
	}
}