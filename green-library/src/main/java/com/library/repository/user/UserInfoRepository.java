package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.UserDto;

@Repository
public class UserInfoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
}
