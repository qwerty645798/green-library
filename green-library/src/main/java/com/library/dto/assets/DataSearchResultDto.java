package com.library.dto.assets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}
