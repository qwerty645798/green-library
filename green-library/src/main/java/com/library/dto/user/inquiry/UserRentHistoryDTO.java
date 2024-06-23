package com.library.dto.user.inquiry;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRentHistoryDTO {
	private int no;
    private int rentNum;
    private String bookTitle;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private String status;
}
