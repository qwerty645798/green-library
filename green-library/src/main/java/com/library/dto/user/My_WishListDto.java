package com.library.dto.user;

import java.sql.Date;

public class My_WishListDto {
	private int wishlistId;
	private String userId;
	private Date wishDate;
	private String wishTitle;
	private String complete;
	
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getWishDate() {
		return wishDate;
	}
	public void setWishDate(Date wishDate) {
		this.wishDate = wishDate;
	}
	public String getWishTitle() {
		return wishTitle;
	}
	public void setWishTitle(String wishTitle) {
		this.wishTitle = wishTitle;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
}
