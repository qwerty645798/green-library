package com.library.dto.admin.bookManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class UpdateBookDTO {

    private int bookID;
    private String title;

    private int authorID;
    private String authorName;

    private int publisherId;
    private String publisherName;
    private Date publicationDate;

    private String genreId;
    private String genreName;
    private String genreFullName;
    private String isbn;

    private String img;
    private String location;
    private String summary;
}
