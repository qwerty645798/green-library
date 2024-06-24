package com.library.dto.user;

import java.sql.Date;

public class BookLoanExtensionDto {
	private String img;
	private String title;
	private String isbn;
	private String authorName;
	private Date rentHistory;
	private Date returnDate;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getRentHistory() {
		return rentHistory;
	}
	public void setRentHistory(Date rentHistory) {
		this.rentHistory = rentHistory;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
