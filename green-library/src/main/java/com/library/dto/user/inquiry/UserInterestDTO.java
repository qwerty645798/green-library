package com.library.dto.user.inquiry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInterestDTO {

	private int no;
	private int interestId;
	private String bookTitle;
	private String bookAuthor;
	private String availability;
	private String genre;
}