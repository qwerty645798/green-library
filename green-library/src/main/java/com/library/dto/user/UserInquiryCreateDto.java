package com.library.dto.user;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInquiryCreateDto {

	@NotBlank(message = "유저 아이디가 입력되지 않았습니다.")
	private String userId;
	
	@NotBlank(message = "문의 제목이 입력되지 않았습니다.")
	private String inquiryTitle;
	
	@NotBlank(message = "문의 내용이 입력되지 않았습니다.")
	private String contents;
	
	@NotBlank(message = "문의 작성일이 입력되지 않았습니다.")
	private Date inquiryDate;
	
}
