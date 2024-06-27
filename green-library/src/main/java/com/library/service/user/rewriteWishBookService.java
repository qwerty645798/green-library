package com.library.service.user;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.user.rewriteWishBookDto;
import com.library.repository.user.rewriteWishBookRepository;

@Service
public class rewriteWishBookService {

	@Autowired
	private rewriteWishBookRepository RewriteWishBookRepository;
	
	public rewriteWishBookDto getWishDetail(int wishlistId) {
		return RewriteWishBookRepository.findByWishlistId(wishlistId);
	}
	
	public void updateWishs(String wishTitle, String wishAuthor, String wishPublisher, Date wishPublication, int wishPrice, String wishIsbn, int wishlistId, String userId) {
		RewriteWishBookRepository.updateWish(wishTitle, wishAuthor, wishPublisher, wishPublication, wishPrice, wishIsbn, wishlistId, userId);
	}
}
