package com.library.mapper.user;

import com.library.dto.user.UserInfoDto;
import com.library.dto.user.UserInfoModificationDto;
import com.library.dto.user.UserJoinDto;
import com.library.dto.user.UserLoginDto;
import com.library.entity.Users;

public interface UserMapper {
    UserLoginDto toUserLoginDto(Users user);
	UserInfoDto toUserInfoDto(Users user);
	Users toEntity(UserInfoModificationDto userDto);
	Users toEntity(UserJoinDto userDto);
	
}