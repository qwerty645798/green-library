package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.BookDetailDto;
import com.library.repository.BookDetailRepository;

@Service
public class BookDetailService {
	
 	@Autowired
 	private BookDetailRepository bookDetailRepository;
 
 	public BookDetailDto getBookDetail(String bookId) {
 		return bookDetailRepository.findByBookId(bookId);
 	}
	
}
