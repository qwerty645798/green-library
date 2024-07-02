package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserCountDTO;
import com.library.dto.user.inquiry.UserInquiryDetailDTO;
import com.library.dto.user.inquiry.UserInterestDTO;
import com.library.dto.user.inquiry.UserRentHistoryDTO;
import com.library.dto.user.inquiry.UserReserveDTO;

@Repository("UserInquiryRepository")
public class InquiryRepositoryImpl implements InquiryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserRentHistoryDTO> getUserRentHistory(String userId) {
        String sql = "SELECT " +
                     "    ROWNUM AS no, " +
                     "    r.rent_num AS rentNum, " +
                     "    b.title AS bookTitle, " +
                     "    r.rent_history AS rentDate, " +
                     "    r.return_date AS returnDate, " +
                     "    CASE " +
                     "        WHEN r.returned = '1' THEN '반납완료' " +
                     "        ELSE '대출중' " +
                     "    END AS status " +
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
                history.setNo(rs.getInt("no"));
                history.setRentNum(rs.getInt("rentNum"));
                history.setBookTitle(rs.getString("bookTitle"));
                history.setRentDate(rs.getDate("rentDate").toLocalDate());
                history.setReturnDate(rs.getDate("returnDate").toLocalDate());
                history.setStatus(rs.getString("status"));
                return history;
            }
        }, userId);
    }

    @Override
    public List<UserBorrowDTO> getUserBorrow(String userId) {
        String sql = "SELECT " +
                     "    ROWNUM AS no, " +
                     "    r.rent_num AS rentNum, " +
                     "    b.title AS bookTitle, " +
                     "    r.rent_history AS rentDate, " +
                     "    r.return_date AS returnDate, " +
                     "    CASE " +
                     "        WHEN r.return_date < SYSDATE THEN '연체' " +
                     "        ELSE '미납' " +
                     "    END AS status " +
                     "FROM " +
                     "    rents r " +
                     "JOIN " +
                     "    books b ON r.book_id = b.book_id " +
                     "WHERE " +
                     "    r.user_id = ? " +
                     "ORDER BY " +
                     "    r.rent_num";

        return jdbcTemplate.query(sql, new RowMapper<UserBorrowDTO>() {
            @Override
            public UserBorrowDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserBorrowDTO history = new UserBorrowDTO();
                history.setNo(rs.getInt("no"));
                history.setRentNum(rs.getInt("rentNum"));
                history.setBookTitle(rs.getString("bookTitle"));
                history.setRentDate(rs.getDate("rentDate").toLocalDate());
                history.setReturnDate(rs.getDate("returnDate").toLocalDate());
                history.setStatus(rs.getString("status"));
                return history;
            }
        }, userId);
    }

    @Override
    public List<UserReserveDTO> getUserReserve(String userId) {
        String sql = "SELECT " +
                     "    ROWNUM AS no, " +
                     "    r.reservation_id AS reservationId, " +
                     "    b.title AS bookTitle, " +
                     "    r.reservation_date AS reservationDate, " +
                     "    CASE " +
                     "        WHEN b.availability = '0' THEN '대출불가능' " +
                     "        ELSE '대출가능' " +
                     "    END AS availability, " +
                     "    DENSE_RANK() OVER (PARTITION BY r.book_id ORDER BY r.reservation_date) AS reservationRank " +
                     "FROM " +
                     "    reservations r " +
                     "JOIN " +
                     "    books b ON r.book_id = b.book_id " +
                     "WHERE " +
                     "    r.user_id = ? " +
                     "ORDER BY " +
                     "    r.reservation_id";

        return jdbcTemplate.query(sql, new RowMapper<UserReserveDTO>() {
            @Override
            public UserReserveDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserReserveDTO reserve = new UserReserveDTO();
                reserve.setNo(rs.getInt("no"));
                reserve.setReservationId(rs.getInt("reservationId"));
                reserve.setBookTitle(rs.getString("bookTitle"));
                reserve.setReservationDate(rs.getDate("reservationDate").toLocalDate());
                reserve.setAvailability(rs.getString("availability"));
                reserve.setReservationRank(rs.getInt("reservationRank"));
                return reserve;
            }
        }, userId);
    }

    @Override
    public List<UserInterestDTO> getUserInterest(String userId) {
    	String sql = "SELECT " +
                "    ROWNUM AS no, " +
                "    ib.interest_id AS interestId, " +
                "    b.title AS bookTitle, " +
                "    a.author_name AS bookAuthor, " +
                "    CASE WHEN b.availability = '1' THEN '대출가능' ELSE '대출불가' END AS availability, " +
                "    g.genre_name AS genre " +
                "FROM " +
                "    interested_books ib " +
                "JOIN " +
                "    books b ON ib.book_id = b.book_id " +
                "JOIN " +
                "    authors a ON b.author_id = a.author_id " +
                "JOIN " +
                "    genres g ON b.genre_id = g.genre_id " +
                "WHERE " +
                "    ib.user_id = ? " +
                "ORDER BY " +
                "    ib.interest_id";


        return jdbcTemplate.query(sql, new RowMapper<UserInterestDTO>() {
            @Override
            public UserInterestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserInterestDTO interest = new UserInterestDTO();
                interest.setNo(rs.getInt("no"));
                interest.setInterestId(rs.getInt("interestId"));
                interest.setBookTitle(rs.getString("bookTitle"));
                interest.setBookAuthor(rs.getString("bookAuthor"));
                interest.setAvailability(rs.getString("availability"));
                interest.setGenre(rs.getString("genre"));
                return interest;
            }
        }, userId);
    }
    
    @Override
    public void getUserInterest(String userId, int bookId) {
    	String sql = "SELECT interest_id FROM interested_books WHERE user_id = ? AND book_id = ?";
        jdbcTemplate.queryForObject(sql, String.class, userId, bookId);
    }
    
    @Override
	public int deleteRentHistory(String id) {
        String sql = "DELETE FROM rents WHERE rent_num = ?";
        return jdbcTemplate.update(sql, id);
    }
	
    @Override
    public int cancelReserve(String reservationId) {
        // 1. 예약 취소
        String deleteSql = "DELETE FROM reservations WHERE reservation_id = ?";
        int result = jdbcTemplate.update(deleteSql, reservationId);

        if (result > 0) {
            // 2. book_id 가져오기
            String selectBookIdSql = "SELECT book_id FROM reservations WHERE reservation_id = ?";
            int bookId = jdbcTemplate.queryForObject(selectBookIdSql, Integer.class, reservationId);

            // 3. 동일한 책에 대해 다른 예약이 있는지 확인
            String checkReservationSql = "SELECT COUNT(*) FROM reservations WHERE book_id = ?";
            int reservationCount = jdbcTemplate.queryForObject(checkReservationSql, Integer.class, bookId);
            // 4. 해당 책이 대출 중인지 확인
            String checkRentSql = "SELECT COUNT(*) FROM rents WHERE book_id = ? AND returned = '0'";
            int rentCount = jdbcTemplate.queryForObject(checkRentSql, Integer.class, bookId);

            // 5. 다른 예약이 없고 대출 중이 아니라면 availability 값을 0으로 업데이트
            if (reservationCount == 0 && rentCount == 0) {
                String updateAvailabilitySql = "UPDATE books SET availability = '0' WHERE book_id = ?";
                jdbcTemplate.update(updateAvailabilitySql, bookId);
            }
        }

        return result;
    }
	
	@Override
	public int deleteInterest(String id) {
        String sql = "DELETE FROM interested_books WHERE interest_id = ?";
        return jdbcTemplate.update(sql, id);
    }
	
	@Override
	public int deleteInterest(String userId, String bookId) {
        String sql = "DELETE FROM interested_books WHERE user_id = ? and book_id = ?";
        return jdbcTemplate.update(sql, userId, bookId);
    }
	
	@Override
	public String checkRentCondition(String userId, String id) {
        String sql = "SELECT returned FROM rents WHERE user_id = ? AND rent_num = ?";
        return jdbcTemplate.queryForObject(sql, String.class, userId, id);
    }
	
	@Override
    public UserCountDTO getUserCount(String userId) {
        String rentSql = "SELECT COUNT(*) FROM rents WHERE user_id = ? and returned = 0";
        String reserveSql = "SELECT COUNT(*) FROM reservations WHERE user_id = ?";

        int rentCount = jdbcTemplate.queryForObject(rentSql, Integer.class, userId);
        int reserveCount = jdbcTemplate.queryForObject(reserveSql, Integer.class, userId);

        UserCountDTO userCountDTO = new UserCountDTO();
        userCountDTO.setRent_count(rentCount);
        userCountDTO.setReserve_count(reserveCount);

        return userCountDTO;
    }
	
	@Override
    public UserInquiryDetailDTO getInquiryDetail(String userId, String id) {
		String sql = "SELECT " +
	                "    i.inquiry_title, " +
	                "    i.inquiry_date, " + 
	                "    i.contents AS inquiry_contents, " +
	                "    r.response_content AS response_contents " +
	                "FROM " +
	                "    inquiries i " +
	                "LEFT JOIN " +
	                "    inquiry_responses r ON i.inquiry_id = r.inquiry_id " +
	                "WHERE " +
	                "    i.inquiry_id = ? AND i.user_id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<UserInquiryDetailDTO>() {
            @Override
            public UserInquiryDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserInquiryDetailDTO dto = new UserInquiryDetailDTO();
                dto.setInquiryTitle(rs.getString("inquiry_title"));
                dto.setInquiryContents(rs.getString("inquiry_contents"));
                dto.setResponseContents(rs.getString("response_contents"));
                dto.setInquiryDate(rs.getDate("inquiry_date").toLocalDate());
                return dto;
            }
        }, id, userId);
    }
	
	@Override
	public int insertInterest(String user_id, String book_id) {
	    String sql = "INSERT INTO interested_books (interest_id, user_id, book_id) VALUES (interest_idx.NEXTVAL, ?, ?)";
	    return jdbcTemplate.update(sql, user_id, book_id);
	}

}
