package com.library.dto;

public class BookDetailDto {

	private String title;
    private int isbn;
    private String authorName;
    private String img;
    private String location;
    private String availability;
    private String summary;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "BookDetailDto [title=" + title + ", isbn=" + isbn + ", authorName=" + authorName + ", img=" + img
				+ ", location=" + location + ", availability=" + availability + ", summary=" + summary + "]";
	}
    
    
}
