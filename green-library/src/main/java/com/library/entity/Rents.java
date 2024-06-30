package com.library.entity;

import java.util.Date;

public class Rents {
    private Long rent_num;
    private Date rent_history;
    private Long book_id;
    private String user_id;
    private Character returned = '0';
	public Long getRent_num() {
		return rent_num;
	}
	public void setRent_num(Long rent_num) {
		this.rent_num = rent_num;
	}
	public Date getRent_history() {
		return rent_history;
	}
	public void setRent_history(Date rent_history) {
		this.rent_history = rent_history;
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Character getReturned() {
		return returned;
	}
	public void setReturned(Character returned) {
		this.returned = returned;
	}
}