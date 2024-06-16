package com.library.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.dto.user.UserDto;

@Repository
public class InfoModificationRepository {

	/*@Autowird
	private JdbcTemplate jdbcTemplate;
	public int updateUserInfo(UserDto userDto) {
        String sql = "UPDATE users SET userName = ?, userEmail = ? WHERE id = ?";
        return jdbcTemplate.update(sql, userDto.getUserName(), user.getUserEmail(), user.getId());
    }*/
}
