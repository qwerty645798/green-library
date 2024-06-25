package com.library.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.user.BookLoanExtensionDto;
import com.library.repository.user.BookLoanExtensionRepository;

@Service
public class BookLoanExtensionService {

	@Autowired
	private BookLoanExtensionRepository bookLoanExtensionRepository;
	
	public List<BookLoanExtensionDto> getLoanList(String userId) {
		return bookLoanExtensionRepository.loanList(userId);
	}
	
	public void getExtension(int bookId) {
		bookLoanExtensionRepository.makeExtension(bookId);
	}
}
