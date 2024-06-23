package com.library.dto.user.inquiry;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReserveDTO {

	private int no;
	private int reservationId;
	private String bookTitle;
	private LocalDate reservationDate;
	private String availability;
	private int reservationRank;
}
