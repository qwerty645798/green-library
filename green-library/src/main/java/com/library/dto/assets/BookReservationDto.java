package com.library.dto.assets;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookReservationDto {
	@NotBlank(message = "예약 번호가 입력되지 않았습니다.")
	private int reservationId;
	
	@NotBlank(message = "유저 아이디가 입력되지 않았습니다.")
	private String userId;
	
	@NotBlank(message = "책 아이디가 입력되지 않았습니다.")
	private int bookId;
	
	@NotBlank(message = "대출 예약일이 입력되지 않았습니다.")
	private Date reservationDate;
	
	@NotBlank(message = "대출 가능 여부가 입력되지 않았습니다.")
	private String availability;
	
	
}
