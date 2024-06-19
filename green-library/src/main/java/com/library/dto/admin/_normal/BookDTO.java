package com.library.dto.admin._normal;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDTO {
    @NotNull
    private int bookId;
    @NotNull
    private int authorId;
    private String authorName;
    @NotNull
    private int publisherId;
    private String publisherName;
    @NotNull
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

