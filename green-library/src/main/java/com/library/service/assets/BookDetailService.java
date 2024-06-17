package com.library.service.assets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.assets.BookDetailDto;
import com.library.repository.assets.BookDetailRepository;

@Service
public class BookDetailService {
	
 	@Autowired
 	private BookDetailRepository bookDetailRepository;
 
 	public BookDetailDto getBookDetail(String bookId) {
 		return bookDetailRepository.findByBookId(bookId);
 	}
	
}
