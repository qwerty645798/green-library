package com.library.dto.user;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HopeBookApplyDto {
	
	@NotBlank(message = "유저 아이디가 입력되지 않았습니다.")
	private String userId;
	
	@NotBlank(message = "신청 날짜가 입력되지 않았습니다.")
	private Date wishDate;
	
	@NotBlank(message = "도서명이 입력되지 않았습니다.")
	private String wishTitle;
	
	@NotBlank(message = "저자명이 입력되지 않았습니다.")
	private String wishAuthor;
	
	@NotBlank(message = "출판사가 입력되지 않았습니다.")
	private String wishPublisher;
	
	@NotBlank(message = "발행년도가 입력되지 않았습니다.")
	private Date wishPublication;
	
	@NotBlank(message = "가격이 입력되지 않았습니다.")
	private int wishPrice;
	
	@NotBlank(message = "ISBN이 입력되지 않았습니다.")
	private String wishIsbn;
	
}
