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
 
 	public BookDetailDto getBookDetail(String bookId) {
 		return bookDetailRepository.findByBookId(bookId);
 	}
	
 	@Autowired
 	private BookReservationRepository bookReservationRepository;
 	
 	public void makeReservation(String bookId, String userId) {
 		bookReservationRepository.reserveBook(bookId, userId);
 	}
 	
 	public void updateAvailability(String bookId, String userId) {
 		bookReservationRepository.reserveBook2(bookId, userId);
 	}
}
