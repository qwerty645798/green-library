package com.library.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.user.My_InquiryDto;
import com.library.dto.user.My_WishListDto;
import com.library.repository.user.My_InquiryRepository;
import com.library.repository.user.My_WishListRepository;

@Service
public class My_WrittenService {

	@Autowired
 	private My_InquiryRepository my_InquiryRepository;
 
 	public List<My_InquiryDto> getMyInquiryList(String userId) {
 		return my_InquiryRepository.myInquiryList(userId);
 	}
	
 	@Autowired
 	private My_WishListRepository my_WishListRepository;
 	
 	public List<My_WishListDto>  getMyWishList(String userId) {
 		return my_WishListRepository.myWishList(userId);
 	}
 	
}
