package com.library.repository.user;

import com.library.entity.Users;

public interface UserRepository {
	Users getUsersEntity(String userId);

	int updateUserInfo(Users user, String userId, String hashedPassword);

	int insertUserInfo(Users user, String hashedPassword);

	int deleteUser(String userId);

}