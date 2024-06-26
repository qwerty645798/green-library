package com.library.service.user;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.user.hopeBookApplyRepository;

@Service
public class HopeBookApplyService {

	@Autowired
	private hopeBookApplyRepository HopeBookApplyRepository;
	
	public void createWish(String userId, String wishTitle, String wishAuthor, String wishPublisher, Date wishPublication, int wishPrice, String wishIsbn) {
		HopeBookApplyRepository.makeWish(userId, wishTitle, wishAuthor, wishPublisher, wishPublication, wishPrice, wishIsbn);
	}
}
