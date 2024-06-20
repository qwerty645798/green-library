package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.UserDto;
import com.library.dto.user.UserInfoModificationDto;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//로그인
	@Override
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
	
	//마이페이지 유저정보 불러오기
	@Override
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

	//회원정보수정
	@Override
    public int updateUserInfo(UserInfoModificationDto userDto, String userId, String hashedPassword) {
        String sql = "UPDATE users SET user_pass = ?, email = ?, phone = ? WHERE user_id = ?";
        return jdbcTemplate.update(sql, hashedPassword, userDto.getEmail(), userDto.getPhone(), userId);
    }
	
	//회원가입
	@Override
    public int insertUserInfo(UserDto userDto, String hashedPassword) {
        String sql = "INSERT INTO users (user_id, user_pass, name, phone, email, birth) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, userDto.getId(), hashedPassword, userDto.getName(), userDto.getPhone(), userDto.getEmail(), userDto.getBirth());
    }

}
