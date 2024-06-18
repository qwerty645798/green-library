package com.library.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.user.UserDto;
import com.library.repository.user.InfoModificationRepository;

@Service
public class UserInfoModificationService {

	@Autowired
	private InfoModificationRepository infoModificationRepository;

	/*
	 * public UserDto update(UserDto userDto) { return
	 * infoModificationRepository.updateUserInfo(userDto); }
	 */

}
