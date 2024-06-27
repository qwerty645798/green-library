package com.library.repository.admin;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@Transactional
@Repository("AdminUserRepository")
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 모든 이용자 목록 조회
    @Override
    public List<UserDTO> allUserManage() {
        String sql = "SELECT USER_ID, NAME, EMAIL, (SELECT COUNT(*) FROM USERS) AS total_count FROM USERS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("USER_ID"));
            user.setUserName(rs.getString("NAME"));
            user.setUserEmail(rs.getString("EMAIL"));
            user.setTotalCount(rs.getInt("total_count"));
            return user;
        });
    }

    // 아이디로 사용자 조회
    @Override
    public List<UserDTO> findUserById(String userId) {
        String sql = "SELECT USER_ID, NAME, EMAIL, (SELECT COUNT(*) FROM USERS) AS total_count FROM USERS WHERE USER_ID LIKE ?";
        String queryParam = "%" + userId + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("USER_ID"));
            user.setUserName(rs.getString("NAME"));
            user.setUserEmail(rs.getString("EMAIL"));
            user.setTotalCount(rs.getInt("total_count"));
            return user;
        });
    }


    // 이름으로 사용자 조회
    @Override
    public List<UserDTO> findUserByName(String name) {
        String sql = "SELECT USER_ID, NAME, EMAIL, (SELECT COUNT(*) FROM USERS) AS total_count FROM USERS WHERE NAME LIKE ?";
        String queryParam = "%" + name + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("USER_ID"));
            user.setUserName(rs.getString("NAME"));
            user.setUserEmail(rs.getString("EMAIL"));
            user.setTotalCount(rs.getInt("total_count"));
            return user;
        });
    }

//    전체에서 이용자 검색
    @Override
    public List<UserDTO> findUserByTotal(String total){
        String sql = "SELECT USER_ID, NAME, EMAIL, (SELECT COUNT(*) FROM USERS) AS total_count FROM USERS WHERE NAME LIKE ? OR USER_ID LIKE ?";
        String queryParam = "%" + total + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            ps.setString(2, queryParam);
            return ps;
        }, (rs, rowNum) ->{
            UserDTO user = new UserDTO();
            user.setUserId(rs.getString("USER_ID"));
            user.setUserName(rs.getString("NAME"));
            user.setUserEmail(rs.getString("EMAIL"));
            user.setTotalCount(rs.getInt("total_count"));
            return user;
        });
    }


    // 특정 이용자 조회
    @Override
    public UserDTO getUserById(String userId) {
        String sql = "SELECT USER_ID, NAME, EMAIL, PHONE FROM USERS WHERE USER_ID = ?";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            return ps;
        }, rs -> {
            if (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("USER_ID"));
                user.setUserName(rs.getString("NAME"));
                user.setUserEmail(rs.getString("EMAIL"));
                user.setUserPhone(rs.getString("PHONE"));
                return user;
            }
            return null;
        });
    }


    // 해당 유저의 대출 현황 조회
    @Override
    public List<RentDTO> loanUserById(String userId) {
        String sql = "SELECT TITLE, AUTHOR_NAME, PUBLISHER_NAME, GENRE_FULLNAME, RENT_HISTORY " + "FROM RENTS " + "JOIN BOOKS ON BOOKS.BOOK_ID = RENTS.BOOK_ID " + "JOIN AUTHORS ON AUTHORS.AUTHOR_ID = BOOKS.AUTHOR_ID " + "JOIN PUBLISHERS ON PUBLISHERS.PUBLISHER_ID = BOOKS.PUBLISHER_ID " + "WHERE USER_ID = ?";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            return ps;
        }, (rs, rowNum) -> {
            RentDTO loan = new RentDTO();
            loan.setBookTitle(rs.getString("BOOK_TITLE"));
            loan.setAuthorName(rs.getString("AUTHOR_NAME"));
            loan.setPublisherName(rs.getString("PUBLISHER_NAME"));
            loan.setGenreFullName(rs.getString("GENRE_FULLNAME"));
            loan.setRentHistory(rs.getDate("RENT_HISTORY"));
            return loan;
        });
    }


    // 해당 유저의 이용 제한 내역 조회
    @Override
    public List<SuspensionDTO> suspensionUserById(String userId) {
        String sql = "SELECT REASON, START_DATE, END_DATE, (END_DATE - START_DATE) AS DURATION " + "FROM SUSPENSIONS " + "WHERE USER_ID = ?";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            return ps;
        }, (rs, rowNum) -> {
            SuspensionDTO suspension = new SuspensionDTO();
            suspension.setReason(rs.getString("REASON"));
            suspension.setStartDate(rs.getDate("START_DATE"));
            suspension.setEndDate(rs.getDate("END_DATE"));
            suspension.setDuration(rs.getInt("DURATION"));
            return suspension;
        });
    }


    // 서비스 제한 생성
    @Override
    public int createSuspension(SuspensionDTO suspension) {
        String sql = "INSERT INTO SUSPENSIONS (SUSPENSION_ID, USER_ID, REASON, START_DATE, END_DATE) VALUES (SUSPEND_IDX.nextval, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, suspension.getUserId(), suspension.getReason(), suspension.getStartDate(), suspension.getEndDate());
    }

    // 유저 영구 삭제
//    void deleteUsers(List<String> userIds);

    //    void releaseSuspension(String userId);
    @Override
    @Transactional
    public void deleteUsers(List<String> userIds) {
        String sql = "DELETE FROM USERS WHERE USER_ID IN (:userIds)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userIds", userIds);
        jdbcTemplate.update(sql, params);
    }

    // 이용 제한 해제
    @Override
    @Transactional
    public void releaseSuspension(String userId) {
        String sql1 = "UPDATE USERS SET SUSPENDED = 0 WHERE USER_ID = ?";
        jdbcTemplate.update(sql1, userId);
        String sql2 = "UPDATE SUSPENSIONS SET END_DATE = SYSDATE WHERE USER_ID = ?";
        jdbcTemplate.update(sql2, userId);
    }
}
