package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.UserRentHistoryDTO;

@Repository("UserInquiryRepository")
public class InquiryRepositoryImpl implements InquiryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserRentHistoryDTO> getUserRentHistory(String userId) {
        String sql = "SELECT " +
                     "    ROWNUM AS NO, " +
                     "    r.rent_num AS \"등록번호\", " +
                     "    b.title AS \"신청도서\", " +
                     "    r.rent_history AS \"대출일\", " +
                     "    CASE " +
                     "        WHEN r.returned = '1' THEN TO_CHAR(r.rent_history + 7, 'YYYY-MM-DD') " +
                     "        ELSE '미납' " +
                     "    END AS \"반납일\", " +
                     "    CASE " +
                     "        WHEN r.returned = '1' THEN '반납완료' " +
                     "        ELSE '대출중' " +
                     "    END AS \"상태\" " +
                     "FROM " +
                     "    rents r " +
                     "JOIN " +
                     "    books b ON r.book_id = b.book_id " +
                     "WHERE " +
                     "    r.user_id = ? " +
                     "ORDER BY " +
                     "    r.rent_num";

        return jdbcTemplate.query(sql, new RowMapper<UserRentHistoryDTO>() {
            @Override
            public UserRentHistoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserRentHistoryDTO history = new UserRentHistoryDTO();
                history.setNo(rs.getInt("NO"));
                history.setRentNum(rs.getInt("등록번호"));
                history.setBookTitle(rs.getString("신청도서"));
                history.setRentHistory(rs.getDate("대출일").toLocalDate());
                history.setReturnDate(rs.getString("반납일"));
                history.setStatus(rs.getString("상태"));
                return history;
            }
        }, userId);
    }
}