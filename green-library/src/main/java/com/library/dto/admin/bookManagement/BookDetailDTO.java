package com.library.dto.admin.bookManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class BookDetailDTO {
    private int bookID;
    private String title;

    private int authorID;
    private String authorName;

    private int publisherID;
    private String publisherName;
    private Date publicationDate;

    private String genreFullName;
    private String isbn;
    private String summary;
    private String bookImg;
}
