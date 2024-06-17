package com.library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.library.dto.UserDto;

public class BookDetailRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDto findByUserId(String userId) {
		String sql = "SELECT user_id, user_pass FROM users WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<UserDto>() {
			@Override
			public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDto user = new UserDto();
				user.setUserId(rs.getString("user_id"));
				user.setUserPass(rs.getString("user_pass"));
				return user;
			}
		}, userId);
	}
}
