package com.library.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.library.dto.user.UserInfoDTO;
import com.library.dto.user.UserInfoModificationDTO;
import com.library.dto.user.UserJoinDTO;

public interface UserService extends UserDetailsService {

    boolean checkUserId(String userId);

    UserInfoDTO getUserInfo(String userId);

    void update(UserInfoModificationDTO userDTO, String userId);

    void insert(UserJoinDTO userDTO);
    
    void deleteUser(String userId);
}