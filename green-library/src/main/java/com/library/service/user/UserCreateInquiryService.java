package com.library.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.user.UserInquiryCreateRepository;

@Service
public class UserCreateInquiryService {

	@Autowired
	private UserInquiryCreateRepository userInquiryCreateRepository;
	
	public void createInquiry(String userId, String inquiryTitle, String contents) {
		userInquiryCreateRepository.makeInquiry(userId, inquiryTitle, contents);
	}
	
	public void modifyInquiry(String inquiryTitle, String contents, String userId, String id) {
		userInquiryCreateRepository.modifyInquiry(inquiryTitle, contents, userId, id);
	}
	
	public void deleteInquiry(String userId, String id) {
		userInquiryCreateRepository.deleteInquiry(userId, id);
	}
}
