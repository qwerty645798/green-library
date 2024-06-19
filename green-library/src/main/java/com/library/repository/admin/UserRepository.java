package com.library.repository.admin;

import com.library.dto.admin._normal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDTO findById(String userId) {
        String sql = "SELECT USER_ID, USER_NAME, USER_EMAIL FROM USERS WHERE USER_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<UserDTO>() {
            @Override
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("USER_ID"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setUserEmail(rs.getString("USER_EMAIL"));
                return user;
            }
        });
    }

    public List<UserDTO> userList() {
        String sql = "SELECT USER_ID, USER_NAME, USER_EMAIL, (SELECT COUNT(*) FROM ANNOUNCEMENT) AS total_count FROM USERS";
        return jdbcTemplate.query(sql, new RowMapper<UserDTO>() {
            @Override
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("USER_ID"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setUserEmail(rs.getString("USER_EMAIL"));
                return user;
            }
        });
    }

    public List<UserDTO> findUserById(String userId) {
        String sql = "SELECT USER_ID, USER_NAME, USER_EMAIL, (SELECT COUNT(*) FROM ANNOUNCEMENT) AS total_count FROM USERS WHERE USER_ID = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<UserDTO>() {
            @Override
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("USER_ID"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setUserEmail(rs.getString("USER_EMAIL"));
                return user;
            }
        });
    }

    public void deleteUser(String userId) {
        String sql = "DELETE FROM USERS WHERE USER_ID = ?";
        jdbcTemplate.update(sql, userId);
    }

    public List<String> findRentStatus(String userId) {
        String sql = "SELECT BOOK_TITLE, AUTHOR_NAME, PUBLISHER_NAME, GENRE_FULLNAME, RENT_HISTORY " +
                "FROM RENTS JOIN BOOKS ON BOOKS.BOOK_ID = RENTS.BOOK_ID " +
                "JOIN AUTHORS ON AUTHOR_ID = BOOKS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON PUBLISHER_ID = BOOKS.PUBLISHER_ID " +
                "WHERE USER_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{userId}, String.class);
    }

    public List<String> findSuspensionInfo(String userId) {
        String sql = "SELECT REASON, START_DATE, (END_DATE - START_DATE) " +
                "FROM SUSPENSIONS WHERE USER_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{userId}, String.class);
    }

    public void releaseSuspension(String userId) {
        String updateUserSql = "UPDATE USERS SET SUSPENDED = 0 WHERE USER_ID = ?";
        jdbcTemplate.update(updateUserSql, userId);

        String updateSuspensionSql = "UPDATE SUSPENSIONS SET END_DATE = SYSDATE WHERE USER_ID = ?";
        jdbcTemplate.update(updateSuspensionSql, userId);
    }

    public void deleteUserPermanently(String userId) {
        String sql = "DELETE FROM USERS WHERE USER_ID = ?";
        jdbcTemplate.update(sql, userId);
    }
}
