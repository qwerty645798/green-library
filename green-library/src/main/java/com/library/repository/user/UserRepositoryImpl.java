package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.entity.Users;

@Repository("UserRepository")
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
	
	// Find ID
	@Override
	public Users getUsersEntity(String name, String birth, String email) {
		String sql = "SELECT user_id, user_pass, name, email, phone, birth, overdue_count, suspended FROM users WHERE name = ? and birth = ? and email = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Users(rs.getString("user_id"), rs.getString("user_pass"), rs.getString("name"),
						rs.getString("email"), rs.getString("phone"), rs.getString("birth"), rs.getInt("overdue_count"),
						rs.getString("suspended").charAt(0));
			}
		}, name, birth, email);
	}
	
	// Find PW
	@Override
	public Users getUsersEntity(String userId, String name, String birth, String email) {
		String sql = "SELECT user_id, user_pass, name, email, phone, birth, overdue_count, suspended FROM users WHERE user_id = ? and name = ? and birth = ? and email = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Users(rs.getString("user_id"), rs.getString("user_pass"), rs.getString("name"),
						rs.getString("email"), rs.getString("phone"), rs.getString("birth"), rs.getInt("overdue_count"),
						rs.getString("suspended").charAt(0));
			}
		},userId, name, birth, email);
	}

	// 회원정보수정
	@Override
	public int updateUserInfo(Users user, String userId, String hashedPassword) {
		String sql = "UPDATE users SET user_pass = ?, email = ?, phone = ? WHERE user_id = ?";
		return jdbcTemplate.update(sql, hashedPassword, user.getEmail(), user.getPhone(), userId);
	}
	
	// 비밀번호 초기화
	@Override
	public int updateUserPass(String email, String hashedPassword) {
		String sql = "UPDATE users SET user_pass = ? WHERE email = ?";
		return jdbcTemplate.update(sql, hashedPassword, email);
	}

	// 회원가입
	@Override
	public int insertUserInfo(Users user, String hashedPassword) {
		String sql = "INSERT INTO users (user_id, user_pass, name, phone, email, birth) VALUES (?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getUser_id(), hashedPassword, user.getName(), user.getPhone(),
				user.getEmail(), user.getBirth());
	}
	
	// 회원탈퇴
	@Override
	public int deleteUser(String userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId);
    }

}
