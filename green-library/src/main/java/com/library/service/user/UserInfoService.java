package com.library.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.library.dto.user.UserDto;
import com.library.repository.user.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
 	private UserInfoRepository userInfoRepository;
 
 	public UserDto getUserDetails() {
 		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated");
        }

        String userId = ((UserDetails) authentication.getPrincipal()).getUsername();
 		return userInfoRepository.findDetailsByUserId(userId);
 	}
    
}