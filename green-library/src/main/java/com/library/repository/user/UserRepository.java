package com.library.repository.user;

import com.library.dto.user.UserDto;
import com.library.dto.user.UserInfoModificationDto;

public interface UserRepository {
    UserDto findByUserId(String userId);
    UserDto findDetailsByUserId(String userId);
    int updateUserInfo(UserInfoModificationDto userDto, String userId, String hashedPassword);
    int insertUserInfo(UserDto userDto, String hashedPassword);
}