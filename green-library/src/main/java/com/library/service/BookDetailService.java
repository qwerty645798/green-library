package com.library.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.BookDetailDto;
import com.library.dto.UserDto;
import com.library.repository.BookDetailRepository;

@Service
public class BookDetailService {
	
 	@Autowired
 	private BookDetailRepository bookDetailRepository;
 
 	@Override
	public BookDetails loadBookByBookId(String bookId) throws BookIdNotFoundException {
	    BookDetailDto bookdetailDto = bookDetailRepository.findByBookId(bookId);
	    
	    if (bookdetailDto == null) {
	        throw new UsernameNotFoundException("User not found");
	    }
	    return User.withUsername(userDto.getUserId())
	               .password(userDto.getUserPass())
	               .authorities(Collections.emptyList()) // 역할을 설정
	               .build();
	}
	
}
