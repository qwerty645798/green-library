package com.library.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.library.dto.user.UserDto;
import com.library.dto.user.UserInfoModificationDto;

public interface UserService extends UserDetailsService {
    UserDto getUserDetails(String userId);
    void update(UserInfoModificationDto userDto, String userId);
    void insert(UserDto userDto);
}