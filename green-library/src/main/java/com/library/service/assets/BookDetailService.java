package com.library.service.assets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.assets.BookDetailDto;
import com.library.repository.assets.BookDetailRepository;
import com.library.repository.assets.BookReservationRepository;

@Service
public class BookDetailService {
	
 	@Autowired
 	private BookDetailRepository bookDetailRepository;
 
 	public BookDetailDto getBookDetail(int bookId) {
 		return bookDetailRepository.findByBookId(bookId);
 	}
	
 	@Autowired
 	private BookReservationRepository bookReservationRepository;
 	
 	public void makeReservation(int bookId, String userId) {
 		bookReservationRepository.reserveBook(bookId, userId);
 	}
 	
 	public void changeAvailability(int bookId) {
 		bookReservationRepository.changeAvail(bookId);
 	}
 	
 	public int reservationsCount(String userId) {
 		return bookReservationRepository.reserveCountByUserId(userId);
 	}
 	
 	
 	
 	public boolean canReserveBook(int bookId, String userId) {
        BookDetailDto bookDetail = bookDetailRepository.findByBookId(bookId);
        int reservationCount = bookReservationRepository.reserveCountByUserId(userId);
        
        if (bookDetail.getAvailability() == null || bookDetail.getAvailability().equals("대출불가")) {
            return false; // 대출 불가 상태
        }
        if (reservationCount >= 5) {
            return false; // 사용자가 이미 5권 이상 예약한 경우
        }
        
        return true; // 예약 가능한 상태
    }
}
