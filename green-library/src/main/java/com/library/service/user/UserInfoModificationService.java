package com.library.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.library.dto.user.UserDto;
import com.library.repository.user.InfoModificationRepository;

public class UserInfoModificationService {
	@Autowired
 	private InfoModificationRepository infoModificationRepository;
 
	/*
	 * public UserDto update(UserDto userDto) { return
	 * infoModificationRepository.updateUserInfo(userDto); }
	 */
}
