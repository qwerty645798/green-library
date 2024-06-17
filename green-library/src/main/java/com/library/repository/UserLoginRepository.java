package com.library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.UserLoginDto;

@Repository
public class UserLoginRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserLoginDto findByUserId(String userId) {
        String sql = "SELECT user_id, user_pass FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<UserLoginDto>() {
            @Override
            public UserLoginDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserLoginDto user = new UserLoginDto();
                user.setUserId(rs.getString("user_id"));
                user.setUserPass(rs.getString("user_pass"));
                return user;
            }
        }, userId);
    }
}
