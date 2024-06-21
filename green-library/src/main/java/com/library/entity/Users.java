package com.library.entity;


public class Users {
    private String user_id;
    private String user_pass;
    private String name;
    private String email;
    private String phone;
    private String birth;
    private Integer overdue_count = 0;
    private Character suspended = '0';
    public Users() {}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Integer getOverdue_count() {
		return overdue_count;
	}
	public void setOverdue_count(Integer overdue_count) {
		this.overdue_count = overdue_count;
	}
	public Character getSuspended() {
		return suspended;
	}
	public void setSuspended(Character suspended) {
		this.suspended = suspended;
	}
	public Users(String user_id, String user_pass, String name, String email, String phone, String birth,
			Integer overdue_count, Character suspended) {
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.overdue_count = overdue_count;
		this.suspended = suspended;
	}
	

}
