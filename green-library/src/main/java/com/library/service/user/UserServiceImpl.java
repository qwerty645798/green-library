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

import com.library.dto.user.UserDto;
import com.library.dto.user.UserInfoModificationDto;
import com.library.exception.DatabaseException;
import com.library.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//로그인(spring security가 자동처리)
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDto userDto = userRepository.findByUserId(userId);
		if (userDto == null) {

			throw new UsernameNotFoundException("User not found");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		return User.withUsername(userDto.getId())
				.password(userDto.getPass())
				.authorities(authorities)
				.build();
	}
	
	//유저 세부정보 불러오기
	@Override
	public UserDto getUserDetails(String userId) {
		 UserDto userDto = userRepository.findDetailsByUserId(userId);
	        if (userDto == null) {
	            throw new UsernameNotFoundException("User not found with id: " + userId);
	        }
	        return userDto;
	}

	//회원정보 수정
	@Override
	@Transactional
	public void update(UserInfoModificationDto userDto ,String userId) {
		String hashedPassword = passwordEncoder.encode(userDto.getPass());
        try {
        	int rowsAffected = userRepository.updateUserInfo(userDto, userId, hashedPassword);
        	if (rowsAffected == 0) {
                throw new DatabaseException("Failed to update user information for user with id: " + userId);
            }
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while updating member with id: " + userId, e);
        }
	}
	
	//회원가입
	@Override
    @Transactional
    public void insert(UserDto userDto) {
        String hashedPassword = passwordEncoder.encode(userDto.getPass());
        try {
        	int rowsAffected = userRepository.insertUserInfo(userDto, hashedPassword);
        	if (rowsAffected == 0) {
                throw new DatabaseException("Failed to update user information for user with id: " + userDto.getId());
            }
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while inserting member with id: " + userDto.getId(), e);
        }
    }

}