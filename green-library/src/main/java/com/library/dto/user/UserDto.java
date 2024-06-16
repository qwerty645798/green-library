package com.library.dto.user;

public class UserDto {

	private String id;
	private String pass;
	private String name;
	private String email;
	private String phone;
	private String birth;
	private int overdue_count;
	private char suspended;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getOverdue_count() {
		return overdue_count;
	}
	public void setOverdue_count(int overdue_count) {
		this.overdue_count = overdue_count;
	}
	public char getSuspended() {
		return suspended;
	}
	public void setSuspended(char suspended) {
		this.suspended = suspended;
	}
}
