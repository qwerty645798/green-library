package com.library.dto.assets;

public class InitiativeBookDto {
	
	private int book_id;
	private String img;
	

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "InitiativeBookDto [book_id=" + book_id + ", img=" + img + "]";
	}

	
}
