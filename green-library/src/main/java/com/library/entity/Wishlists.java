package com.library.entity;

import java.util.Date;

public class Wishlists {
    private Long wishlist_id;
    private String wish_title;
    private String wish_author;
    private String wish_publisher;
    private Date wish_publication;
    private Integer wish_price = 10000;
    private String wish_isbn;
    private Date wish_date;
    private Character complete = 'W';
    private String user_id;
	public Long getWishlist_id() {
		return wishlist_id;
	}
	public void setWishlist_id(Long wishlist_id) {
		this.wishlist_id = wishlist_id;
	}
	public String getWish_title() {
		return wish_title;
	}
	public void setWish_title(String wish_title) {
		this.wish_title = wish_title;
	}
	public String getWish_author() {
		return wish_author;
	}
	public void setWish_author(String wish_author) {
		this.wish_author = wish_author;
	}
	public String getWish_publisher() {
		return wish_publisher;
	}
	public void setWish_publisher(String wish_publisher) {
		this.wish_publisher = wish_publisher;
	}
	public Date getWish_publication() {
		return wish_publication;
	}
	public void setWish_publication(Date wish_publication) {
		this.wish_publication = wish_publication;
	}
	public Integer getWish_price() {
		return wish_price;
	}
	public void setWish_price(Integer wish_price) {
		this.wish_price = wish_price;
	}
	public String getWish_isbn() {
		return wish_isbn;
	}
	public void setWish_isbn(String wish_isbn) {
		this.wish_isbn = wish_isbn;
	}
	public Date getWish_date() {
		return wish_date;
	}
	public void setWish_date(Date wish_date) {
		this.wish_date = wish_date;
	}
	public Character getComplete() {
		return complete;
	}
	public void setComplete(Character complete) {
		this.complete = complete;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}