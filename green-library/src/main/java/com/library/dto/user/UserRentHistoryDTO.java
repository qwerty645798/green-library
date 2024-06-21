package com.library.dto.user;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRentHistoryDTO {
	private int no;
    private int rentNum;
    private String bookTitle;
    private LocalDate rentHistory;
    private String returnDate;
    private String status;
}
