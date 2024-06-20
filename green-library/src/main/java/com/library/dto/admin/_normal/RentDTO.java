package com.library.dto.admin._normal;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RentDTO {
    private String bookTitle;
    private String authorName;
    private String publisherName;
    private String genreFullName;
    private Date rentHistory;
    private Long rentNum;
    private Long bookId;
    private String userId;
    private Character returned;
}

