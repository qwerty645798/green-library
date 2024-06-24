package com.library.mapper.user;

import com.library.dto.user.UserInfoDTO;
import com.library.dto.user.UserInfoModificationDTO;
import com.library.dto.user.UserJoinDTO;
import com.library.dto.user.UserLoginDTO;
import com.library.entity.Users;

public interface UserMapper {
    UserLoginDTO toUserLoginDTO(Users user);
	UserInfoDTO toUserInfoDTO(Users user);
	Users toEntity(UserInfoModificationDTO userDTO);
	Users toEntity(UserJoinDTO userDTO);
	
}