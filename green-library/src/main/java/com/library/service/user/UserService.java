package com.library.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.library.dto.user.UserInfoDto;
import com.library.dto.user.UserInfoModificationDto;
import com.library.dto.user.UserJoinDto;

public interface UserService extends UserDetailsService {

    boolean checkUserId(String userId);

    UserInfoDto getUserInfo(String userId);

    void update(UserInfoModificationDto userDto, String userId);

    void insert(UserJoinDto userDto);
}