package com.library.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dto.user.UserInfoDto;
import com.library.dto.user.UserInfoModificationDto;
import com.library.dto.user.UserJoinDto;
import com.library.dto.user.UserLoginDto;
import com.library.entity.Users;
import com.library.exception.DatabaseException;
import com.library.mapper.user.UserMapper;
import com.library.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// 로그인(spring security가 자동처리)
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Users user = userRepository.getUsersEntity(userId);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		UserLoginDto userDto = userMapper.toUserLoginDto(user);
		List<GrantedAuthority> authorities = new ArrayList<>();

		return User.withUsername(userDto.getUser_id()).password(userDto.getUser_pass()).authorities(authorities)
				.build();
	}
	
	//아이디 중복체크
	public boolean checkUserId(String userId) {
        Users user = userRepository.getUsersEntity(userId);
        return user != null;
    }

	// 유저 세부정보 불러오기
	@Override
	public UserInfoDto getUserInfo(String userId) {
		Users user = userRepository.getUsersEntity(userId);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		UserInfoDto userDto = userMapper.toUserInfoDto(user);
		return userDto;
	}

	// 회원정보 수정
	@Override
	@Transactional
	public void update(UserInfoModificationDto userDto, String userId) {
		String hashedPassword = passwordEncoder.encode(userDto.getUser_pass());
		Users user = userMapper.toEntity(userDto);

		try {
			int rowsAffected = userRepository.updateUserInfo(user, userId, hashedPassword);
			if (rowsAffected == 0) {
				throw new DatabaseException("Failed to update user information for user with id: " + userId);
			}
		} catch (DataAccessException e) {
			throw new DatabaseException("Database error occurred while updating member with id: " + userId, e);
		}
	}

	// 회원가입
	@Transactional
	@Override
	public void insert(UserJoinDto userDto) {
		String hashedPassword = passwordEncoder.encode(userDto.getUser_pass());
		Users user = userMapper.toEntity(userDto);

		try {
			int rowsAffected = userRepository.insertUserInfo(user, hashedPassword);
			if (rowsAffected == 0) {
				throw new DatabaseException(
						"Failed to insert user information for user with id: " + userDto.getUser_id());
			}
		} catch (DataAccessException e) {
			throw new DatabaseException(
					"Database error occurred while inserting member with id: " + userDto.getUser_id(), e);
		}
	}

}