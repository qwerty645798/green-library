package com.library.dto.admin.bookManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class BookSearchDTO {
    private int bookId;
    private String title;
    private String authorID;
    private String authorName;
    private String publisherID;
    private String publisherName;
    private Date publicationDate;
    private String genreFullName;
    private String genreName;
    private String genreID;
    private char availability;
    private String keyword;
}
