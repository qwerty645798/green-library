package com.library.dto.user;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookLoanExtensionDto {
	
	private String img;
	private String title;
	private String isbn;
	private String authorName;
	private Date rentHistory;
	
	@NotBlank(message = "반납일이 입력되지 않았습니다.")
	private Date returnDate;
	
	
}
