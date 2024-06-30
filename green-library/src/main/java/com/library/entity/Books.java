package com.library.entity;

import java.util.Date;

public class Books {
    private Long book_id;
    private Long author_id;
    private Long publisher_id;
    private String genre_id;
    private String genre_fullname;
    private String title;
    private String img;
    private String isbn;
    private String location;
    private Character availability = '1';
    private String summary;
    private Date publication_date;
    private Integer borrow_count = 0;
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public Long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	public Long getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(Long publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}
	public String getGenre_fullname() {
		return genre_fullname;
	}
	public void setGenre_fullname(String genre_fullname) {
		this.genre_fullname = genre_fullname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Character getAvailability() {
		return availability;
	}
	public void setAvailability(Character availability) {
		this.availability = availability;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}
	public Integer getBorrow_count() {
		return borrow_count;
	}
	public void setBorrow_count(Integer borrow_count) {
		this.borrow_count = borrow_count;
	}
}