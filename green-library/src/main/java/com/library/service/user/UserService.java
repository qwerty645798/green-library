package com.library.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.dto.user.UserDto;
import com.library.repository.user.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDto userDto = userRepository.findByUserId(userId);
		if (userDto == null) {

			throw new UsernameNotFoundException("UserDto not found");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		return User.withUsername(userDto.getId()).password(userDto.getPass()).authorities(authorities)

				.build();
	}

	public UserDto getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			throw new RuntimeException("User is not authenticated");
		}

		String userId = ((UserDetails) authentication.getPrincipal()).getUsername();
		return userRepository.findDetailsByUserId(userId);
	}

	public boolean update(UserDto userDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			throw new RuntimeException("User is not authenticated");
		}

		String userId = ((UserDetails) authentication.getPrincipal()).getUsername();
		return userRepository.updateUserInfo(userDto, userId);
	}

}