package com.library.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

import com.library.dto.user.account.UserFindingIdDTO;
import com.library.dto.user.account.UserFindingPwDTO;
import com.library.dto.user.account.UserJoinDTO;
import com.library.dto.user.account.UserLoginDTO;
import com.library.dto.user.account.initializePasswordDTO;
import com.library.dto.user.profile.UserInfoDTO;
import com.library.dto.user.profile.UserInfoModificationDTO;
import com.library.entity.Users;
import com.library.exception.DatabaseException;
import com.library.exception.UserNotFoundException;
import com.library.mapper.user.UserMapper;
import com.library.repository.user.UserRepository;
import com.library.service.RedisService;
import com.library.service.email.EmailSender;

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
    private EmailSender emailSender;
	
	@Autowired
    private RedisService redisService;

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
	
	// 회원정보수정을 위한 인증
	@Override
	public boolean checkUserPass(String userPass) {
        try{
        	userRepository.getUsersEntity(userPass);
        	return true;
        } catch (EmptyResultDataAccessException e) {
        	return false;
        }
    }
	
	//아이디 중복체크
	@Override
	public boolean checkUserId(String userId) {
        try{
        	userRepository.getUsersEntity(userId);
        	return true;
        } catch (EmptyResultDataAccessException e) {
        	return false;
        }
    }
	
	//가입된 사용자인지 체크
	@Override
	public boolean checkUserAccount(UserJoinDTO userDTO) {
        try{
        	userRepository.getUsersEntity(userDTO.getBirth(), userDTO.getName());
        	return true;
        } catch (EmptyResultDataAccessException e) {
        	return false;
        }
    }
	
	// 유저 아이디 찾기
	@Override
	public String findUserId(UserFindingIdDTO userDTO) {
		try{
			Users user = userRepository.getUsersEntity(userDTO.getName(), userDTO.getBirth(), userDTO.getEmail());
			String userId = user.getUser_id();
			return userId;
		} catch (EmptyResultDataAccessException e) {
			logger.warn("User Finding id failed - User not found with name: {}", userDTO.getName(), e);
            throw new DatabaseException("User Finding id failed - User not found with name: {}" + userDTO.getName(), e);
        }
	}
	
	// 유저 비밀번호 초기화를 위한 검증
	@Override
	public void checkUserInfo(UserFindingPwDTO userDTO) {
		try{
			userRepository.getUsersEntity(userDTO.getUser_id(), userDTO.getName(), userDTO.getBirth(), userDTO.getEmail());
			sendVerificationEmail(userDTO.getEmail());
		} catch (EmptyResultDataAccessException e) {
			logger.warn("User information checking failed - User not found with userId: {}", userDTO.getUser_id(), e);
            throw new DatabaseException("User information checking failed - User not found with userId: " + userDTO.getUser_id(), e);
        }
	}
	
	// 비밀번호 초기화
	@Override
	public void initializePassword(initializePasswordDTO userDTO) {
		String hashedPassword = passwordEncoder.encode(userDTO.getUser_pass());
		try {
			int rowsAffected = userRepository.updateUserPass(userDTO.getEmail(), hashedPassword);
			if (rowsAffected == 0) {
				throw new DatabaseException("Failed to update user password for user with email: " + userDTO.getEmail());
			}
		} catch (DataAccessException e) {
			throw new DatabaseException("Database error occurred while updating password for member with email: " + userDTO.getEmail(), e);
		}
	}
	
	// 이메일 발송, 토큰 캐싱
	@Override
	public void sendVerificationEmail(String email) {
        String token = UUID.randomUUID().toString();
        redisService.saveToken(token, email);
        emailSender.sendEmail(email, token);
    }

	// 이메일인증
	@Override
    public String verifyUser(String token) {
        String email = redisService.getEmailByToken(token);
        if (email != null) {
            redisService.deleteToken(token);
            return email;
        }
		else {
            throw new UserNotFoundException("User authentication failed - User not found with email: " + email);
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