package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.entity.Users;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Users
	@Override
	public Users getUsersEntity(String userId) {
		String sql = "SELECT user_id, user_pass, name, email, phone, birth, overdue_count, suspended FROM users WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Users(rs.getString("user_id"), rs.getString("user_pass"), rs.getString("name"),
						rs.getString("email"), rs.getString("phone"), rs.getString("birth"), rs.getInt("overdue_count"),
						rs.getString("suspended").charAt(0));
			}
		}, userId);
	}

	// 회원정보수정
	@Override
	public int updateUserInfo(Users user, String userId, String hashedPassword) {
		String sql = "UPDATE users SET user_pass = ?, email = ?, phone = ? WHERE user_id = ?";
		return jdbcTemplate.update(sql, hashedPassword, user.getEmail(), user.getPhone(), userId);
	}

	// 회원가입
	@Override
	public int insertUserInfo(Users user, String hashedPassword) {
		String sql = "INSERT INTO users (user_id, user_pass, name, phone, email, birth) VALUES (?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getUser_id(), hashedPassword, user.getName(), user.getPhone(),
				user.getEmail(), user.getBirth());
	}

}
