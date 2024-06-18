package com.library.dto.assets;

public class DataSearchResultDto {

	private int bookId;
	private String img;
	private String title;
	private String availability;
	private String authorName;
	private String location;
	private String publisherName;
	private String isbn;
	private String summary;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
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
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "DataSearchResultDto [bookId=" + bookId + ", img=" + img + ", title=" + title + ", availability="
				+ availability + ", authorName=" + authorName + ", location=" + location + ", publisherName="
				+ publisherName + ", isbn=" + isbn + ", summary=" + summary + "]";
	}
	
	
	
	
	
}
