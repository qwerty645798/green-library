package com.library.dto.admin._normal;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDTO {
    private int bookId;
    private int authorId;
    private String authorName;
    private int publisherId;
    private String publisherName;
    private String genreId;
    private String genreFullname;
    private String title;
    private String img;
    private String isbn;
    private String location;
    private Character availability;
    private String summary;
    private Date publicationDate;
    private int borrowCount;
}

