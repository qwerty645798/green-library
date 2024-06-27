package com.library.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.user.WishBookDto;
import com.library.repository.user.WishBookRepository;

@Service
public class WishBookService {

	@Autowired
	private WishBookRepository wishBookRepository;
	
	public WishBookDto getWishBookDetail(int wishId) {
		return wishBookRepository.findByWishId(wishId);
	}
}
