package com.library.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.library.dto.user.account.UserFindingIdDTO;
import com.library.dto.user.account.UserFindingPwDTO;
import com.library.dto.user.account.UserJoinDTO;
import com.library.dto.user.account.initializePasswordDTO;
import com.library.dto.user.profile.UserInfoDTO;
import com.library.dto.user.profile.UserInfoModificationDTO;

public interface UserService extends UserDetailsService {

    boolean checkUserId(String userId);
    
    String findUserId(UserFindingIdDTO userDTO);
    
    void checkUserInfo(UserFindingPwDTO userDTO);

    UserInfoDTO getUserInfo(String userId);

    void update(UserInfoModificationDTO userDTO, String userId);

    void insert(UserJoinDTO userDTO);
    
    void deleteUser(String userId);

	void sendVerificationEmail(String email);

	String verifyUser(String token);

	void initializePassword(initializePasswordDTO userDTO);
}