package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.UserDto;
import com.library.exception.DatabaseException;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDto findByUserId(String userId) {
		String sql = "SELECT user_id, user_pass FROM users WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<UserDto>() {
			@Override
			public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDto user = new UserDto();
				user.setId(rs.getString("user_id"));
				user.setPass(rs.getString("user_pass"));

				return user;
			}
		}, userId);
	}

	public UserDto findDetailsByUserId(String userId) {
		String sql = "SELECT user_id, name, email, phone, birth FROM users WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<UserDto>() {
			@Override
			public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDto user = new UserDto();
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("name"));
				user.setBirth(rs.getString("birth"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		}, userId);
	}

	public boolean updateUserInfo(UserDto userDto, String userId) {
		String sql = "UPDATE users SET user_pass = ?, email = ?, phone = ? WHERE id = ?";
		try {
			int rowsAffected = jdbcTemplate.update(sql, userDto.getPass(), userDto.getEmail(), userDto.getPhone(), userId);
			if (rowsAffected == 0) {
	            throw new DatabaseException("No member found with id: " + userDto.getId());
	        }
			return rowsAffected == 1;
		}catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while updating member with id: " + userDto.getId(), e);
        }
	}

}
