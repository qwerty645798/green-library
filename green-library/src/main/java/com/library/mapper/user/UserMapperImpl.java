package com.library.mapper.user;

import org.springframework.stereotype.Component;

import com.library.dto.user.UserInfoDTO;
import com.library.dto.user.UserInfoModificationDTO;
import com.library.dto.user.UserJoinDTO;
import com.library.dto.user.UserLoginDTO;
import com.library.entity.Users;

@Component("UserMapper")
public class UserMapperImpl implements UserMapper {

	@Override
	public UserLoginDTO toUserLoginDTO(Users user) {
		if (user == null) {
			return null;
		}

		UserLoginDTO userLoginDTO = new UserLoginDTO();
		userLoginDTO.setUser_id(user.getUser_id());
		userLoginDTO.setUser_pass(user.getUser_pass());

		return userLoginDTO;
	}

	@Override
	public UserInfoDTO toUserInfoDTO(Users user) {
		if (user == null) {
			return null;
		}
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setUser_id(user.getUser_id());
		userInfoDTO.setName(user.getName());
		userInfoDTO.setBirth(user.getBirth());
		userInfoDTO.setPhone(user.getPhone());
		userInfoDTO.setEmail(user.getEmail());

		return userInfoDTO;
	}

	@Override
	public Users toEntity(UserInfoModificationDTO userDTO) {
		if (userDTO == null) {
			return null;
		}

		Users user = new Users();
		user.setUser_pass(userDTO.getUser_pass());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());

		return user;
	}

	@Override
	public Users toEntity(UserJoinDTO userDTO) {
		if (userDTO == null) {
			return null;
		}

		Users user = new Users();
		user.setUser_id(userDTO.getUser_id());
		user.setUser_pass(userDTO.getUser_pass());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setBirth(userDTO.getBirth());

		return user;
	}
}