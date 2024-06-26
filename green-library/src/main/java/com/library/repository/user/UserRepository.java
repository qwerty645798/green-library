package com.library.repository.user;

import com.library.entity.Users;

public interface UserRepository {
	Users getUsersEntity(String userId);

	int updateUserInfo(Users user, String userId, String hashedPassword);

	int insertUserInfo(Users user, String hashedPassword);

	int deleteUser(String userId);

	Users getUsersEntity(String name, String birth, String email);

	Users getUsersEntity(String userId, String name, String birth, String email);

	int updateUserPass(String email, String hashedPassword);

	Users getUsersEntity(String birth, String name);

	String getUserPass(String userId);
}