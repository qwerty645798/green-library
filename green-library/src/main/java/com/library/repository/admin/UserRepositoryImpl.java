package com.library.repository.admin;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AdminUserRepository")
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 모든 이용자 목록 조회
    @Override
    public List<UserDTO> allUserManage() {
        String sql = "SELECT USER_ID, USER_NAME, USER_EMAIL, (SELECT COUNT(*) FROM USERS) AS total_count FROM USERS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setUserEmail(rs.getString("user_email"));
            return user;
        });
    }

    // 아이디로 사용자 조회
    @Override
    public List<UserDTO> findUserById(String userId) {
        String sql = "SELECT USER_ID, USER_NAME, USER_EMAIL, (SELECT COUNT(*) FROM USERS) AS total_count" +
                "FROM USERS WHERE USER_ID LIKE ?";
        String queryParam = "%" + userId + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setUserEmail(rs.getString("user_email"));
            return user;
        });
    }

    // 이름으로 사용자 조회
    @Override
    public List<UserDTO> findUserByName(String userName) {
        String sql = "SELECT USER_ID, USER_NAME, USER_EMAIL , (SELECT COUNT(*) FROM USERS) AS total_count" +
                "FROM USERS WHERE USER_NAME LIKE ?";
        String queryParam = "%" + userName + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setUserEmail(rs.getString("user_email"));
            return user;
        });
    }

    // 특정 이용자 조회
    @Override
    public UserDTO getUserById(int userId) {
        String sql = "SELECT USER_ID, USER_NAME, USER_EMAIL, PHONE FROM USERS WHERE USER_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setUserEmail(rs.getString("user_email"));
            user.setUserPhone(rs.getString("phone"));
            return user;
        });
    }

    // 해당 유저의 대출 현황 조회
    @Override
    public List<RentDTO> loanUserById(int userId) {
        String sql = "SELECT BOOK_TITLE, AUTHOR_NAME, PUBLISHER_NAME, GENRE_FULLNAME, RENT_HISTORY " +
                "FROM RENTS " +
                "JOIN BOOKS ON BOOKS.BOOK_ID = RENTS.BOOK_ID " +
                "JOIN AUTHORS ON AUTHOR_ID = BOOKS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON PUBLISHER_ID = BOOKS.PUBLISHER_ID " +
                "WHERE USER_ID = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            RentDTO loan = new RentDTO();
            loan.setBookTitle(rs.getString("book_title"));
            loan.setAuthorName(rs.getString("author_name"));
            loan.setPublisherName(rs.getString("publisher_name"));
            loan.setGenreFullName(rs.getString("genre_fullname"));
            loan.setRentHistory(rs.getDate("rent_history"));
            return loan;
        });
    }

    // 해당 유저의 이용 제한 내역 조회
    @Override
    public List<SuspensionDTO> suspensionUserById(int userId) {
        String sql = "SELECT REASON, START_DATE, END_DATE, (END_DATE - START_DATE) AS DURATION " +
                "FROM SUSPENSIONS " +
                "WHERE USER_ID = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            SuspensionDTO suspension = new SuspensionDTO();
            suspension.setReason(rs.getString("reason"));
            suspension.setStartDate(rs.getDate("start_date"));
            suspension.setEndDate(rs.getDate("end_date"));
            suspension.setDuration(rs.getInt("duration"));
            return suspension;
        });
    }

    // 서비스 제한 생성
    @Override
    public int createSuspension(SuspensionDTO suspension) {
        String sql = "INSERT INTO SUSPENSIONS (USER_ID, REASON, START_DATE, END_DATE) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, suspension.getUserId(), suspension.getReason(), suspension.getStartDate(), suspension.getEndDate());
    }

    // 유저 영구 삭제
    @Override
    public void deleteUsers(int userId) {
        String sql = "DELETE FROM USERS WHERE USER_ID = ?";
        jdbcTemplate.update(sql, userId);
    }

    // 이용 제한 해제
    @Override
    public void releaseSuspension(int userId) {
        String sql1 = "UPDATE USERS SET SUSPENDED = 0 WHERE USER_ID = ?";
        String sql2 = "UPDATE SUSPENSIONS SET END_DATE = SYSDATE WHERE USER_ID = ?";
        jdbcTemplate.update(sql1, userId);
        jdbcTemplate.update(sql2, userId);
    }
}
