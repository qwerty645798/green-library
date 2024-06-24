package com.library.dto.assets;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PopularBookDto {

	private int book_id;
	private String img;
	private String title;
    private String authorName;
    private String publisherName;
    private String availability;
    private Date publicationDate;
    
	
}
