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
	
	public boolean allLoanList(String userId) {
        int rentCount = bookLoanExtensionRepository.rentCountByUserId(userId);
        System.out.println(rentCount);
        if (rentCount < 1) {
            return false; // 사용자가 대출하고 있는 책이 없는 경우
        }
        
        return true; // 대출하고 있는 책이 있는 경우
    }
	
}
