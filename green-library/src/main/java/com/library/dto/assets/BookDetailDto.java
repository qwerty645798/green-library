package com.library.dto.assets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDetailDto {

	private String title;
    private int isbn;
    private String authorName;
    private String img;
    private String location;
    private String availability;
    private String summary;
    
}
