package com.library.mapper.user;

import com.library.dto.user.account.UserJoinDTO;
import com.library.dto.user.account.UserLoginDTO;
import com.library.dto.user.profile.UserInfoDTO;
import com.library.dto.user.profile.UserInfoModificationDTO;
import com.library.entity.Users;

public interface UserMapper {
    UserLoginDTO toUserLoginDTO(Users user);
	UserInfoDTO toUserInfoDTO(Users user);
	Users toEntity(UserInfoModificationDTO userDTO);
	Users toEntity(UserJoinDTO userDTO);
	
}