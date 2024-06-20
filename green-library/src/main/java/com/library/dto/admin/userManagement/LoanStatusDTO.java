package com.library.dto.admin.userManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class LoanStatusDTO {
    private int userID;

    private int bookID;
    private int rentID;
    private int loanID;
    private int authorID;
    private int publisherID;

    private int bookTitle;
    private int bookAuthorName;
    private int bookPublisherName;
    private int genreFullName;
    private Date rentHistory;
}
