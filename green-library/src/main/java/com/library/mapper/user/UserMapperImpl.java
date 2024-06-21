package com.library.mapper.user;

import org.springframework.stereotype.Component;

import com.library.dto.user.UserInfoDto;
import com.library.dto.user.UserInfoModificationDto;
import com.library.dto.user.UserJoinDto;
import com.library.dto.user.UserLoginDto;
import com.library.entity.Users;

@Component("UserMapper")
public class UserMapperImpl implements UserMapper {

	@Override
	public UserLoginDto toUserLoginDto(Users user) {
		if (user == null) {
			return null;
		}

		UserLoginDto userLoginDto = new UserLoginDto();
		userLoginDto.setUser_id(user.getUser_id());
		userLoginDto.setUser_pass(user.getUser_pass());

		return userLoginDto;
	}

	@Override
	public UserInfoDto toUserInfoDto(Users user) {
		if (user == null) {
			return null;
		}
		UserInfoDto userInfoDto = new UserInfoDto();
		userInfoDto.setUser_id(user.getUser_id());
		userInfoDto.setName(user.getName());
		userInfoDto.setBirth(user.getBirth());
		userInfoDto.setPhone(user.getPhone());
		userInfoDto.setEmail(user.getEmail());

		return userInfoDto;
	}

	@Override
	public Users toEntity(UserInfoModificationDto userDto) {
		if (userDto == null) {
			return null;
		}

		Users user = new Users();
		user.setUser_pass(userDto.getUser_pass());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());

		return user;
	}

	@Override
	public Users toEntity(UserJoinDto userDto) {
		if (userDto == null) {
			return null;
		}

		Users user = new Users();
		user.setUser_id(userDto.getUser_id());
		user.setUser_pass(userDto.getUser_pass());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());
		user.setBirth(userDto.getBirth());

		return user;
	}
}