package com.library.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.dto.user.account.UserJoinDTO;
import com.library.dto.user.account.UserLoginDTO;
import com.library.dto.user.profile.UserInfoDTO;
import com.library.dto.user.profile.UserInfoModificationDTO;
import com.library.entity.Users;
import com.library.exception.DatabaseException;
import com.library.mapper.user.UserMapper;
import com.library.repository.user.UserRepository;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier("UserRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("UserMapper")
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// 로그인(spring security가 자동처리)
	@Override
	public UserDetails loadUserByUsername(String userId) {
		try{
			Users user = userRepository.getUsersEntity(userId);
			UserLoginDTO userDTO = userMapper.toUserLoginDTO(user);
			List<GrantedAuthority> authorities = new ArrayList<>();
	
			return User
					.withUsername(userDTO.getUser_id())
					.password(userDTO.getUser_pass())
					.authorities(authorities)
					.build();
		} catch (EmptyResultDataAccessException e) {
			logger.warn("Login failed - User not found with userId: {}", userId, e);
            throw new UsernameNotFoundException("Login failed - User not found with userId: " + userId, e);
	    }
	}
	
	//아이디 중복체크
	public boolean checkUserId(String userId) {
        try{
        	userRepository.getUsersEntity(userId);
        	return true;
        } catch (EmptyResultDataAccessException e) {
        	return false;
        }
    }
	
	

	// 유저 세부정보 불러오기
	@Override
	public UserInfoDTO getUserInfo(String userId) {
		try{
			Users user = userRepository.getUsersEntity(userId);
			UserInfoDTO userDTO = userMapper.toUserInfoDTO(user);
			return userDTO;
		} catch (EmptyResultDataAccessException e) {
			logger.warn("User information retrieval failed - User not found with userId: {}", userId, e);
            throw new DatabaseException("User information retrieval failed - User not found with userId: " + userId, e);
        }
	}

	// 회원정보 수정
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(UserInfoModificationDTO userDTO, String userId) {
		String hashedPassword = passwordEncoder.encode(userDTO.getUser_pass());
		Users user = userMapper.toEntity(userDTO);

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
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insert(UserJoinDTO userDTO) {
		String hashedPassword = passwordEncoder.encode(userDTO.getUser_pass());
		Users user = userMapper.toEntity(userDTO);

		try {
			int rowsAffected = userRepository.insertUserInfo(user, hashedPassword);
			if (rowsAffected == 0) {
				throw new DatabaseException(
						"Failed to insert user information for user with id: " + userDTO.getUser_id());
			}
		} catch (DataAccessException e) {
			throw new DatabaseException(
					"Database error occurred while inserting member with id: " + userDTO.getUser_id(), e);
		}
	}
	
	// 회원탈퇴
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteUser(String userId) {
        try {
            int rowsAffected = userRepository.deleteUser(userId);
            if (rowsAffected == 0) {
                throw new DatabaseException("Failed to delete user with id: " + userId);
            }
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while deleting user with id: " + userId, e);
        }
    }
    
}