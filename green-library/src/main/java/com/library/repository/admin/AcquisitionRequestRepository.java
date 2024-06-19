package com.library.repository.admin;

import com.library.dto.admin.acquisitionManagement.AcquisitionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AcquisitionRequestRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 도서 획득 요청 목록 조회
    public List<AcquisitionRequestDTO> acquisitionRequestManage() {
        String sql = "SELECT REQUEST_ID, BOOK_TITLE, AUTHOR_NAME, PUBLISHER_NAME, GENRE_FULLNAME, REQUEST_DATE, " +
                "SUMMARY, REQUEST_STATUS FROM ACQUISITION_REQUESTS " +
                "JOIN BOOKS ON ACQUISITION_REQUESTS.BOOK_ID = BOOKS.BOOK_ID " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID " +
                "JOIN GENRES ON BOOKS.GENRE_ID = GENRES.GENRE_ID";
        return jdbcTemplate.query(sql, new RowMapper<AcquisitionRequestDTO>() {
            @Override
            public AcquisitionRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AcquisitionRequestDTO request = new AcquisitionRequestDTO();
                request.setRequestId(rs.getInt("REQUEST_ID"));
                request.setBookTitle(rs.getString("BOOK_TITLE"));
                request.setAuthorName(rs.getString("AUTHOR_NAME"));
                request.setPublisherName(rs.getString("PUBLISHER_NAME"));
                request.setGenreFullName(rs.getString("GENRE_FULLNAME"));
                request.setRequestDate(rs.getDate("REQUEST_DATE"));
                request.setSummary(rs.getString("SUMMARY"));
                request.setRequestStatus(rs.getString("REQUEST_STATUS"));
                return request;
            }
        });
    }

    // 도서 획득 요청 등록
    public void createAcquisitionRequest(Integer bookId, String summary, String requestStatus) {
        String sql = "INSERT INTO ACQUISITION_REQUESTS (REQUEST_ID, BOOK_ID, SUMMARY, REQUEST_STATUS, REQUEST_DATE) " +
                "VALUES (REQUESTS.NEXTVAL, ?, ?, ?, SYSDATE)";
        jdbcTemplate.update(sql, bookId, summary, requestStatus);
    }

    // 도서 획득 요청 상세 조회
    public AcquisitionRequestDTO findAcquisitionRequestById(Integer requestId) {
        String sql = "SELECT REQUEST_ID, BOOK_TITLE, AUTHOR_NAME, PUBLISHER_NAME, GENRE_FULLNAME, REQUEST_DATE, " +
                "SUMMARY, REQUEST_STATUS FROM ACQUISITION_REQUESTS " +
                "JOIN BOOKS ON ACQUISITION_REQUESTS.BOOK_ID = BOOKS.BOOK_ID " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID " +
                "JOIN GENRES ON BOOKS.GENRE_ID = GENRES.GENRE_ID " +
                "WHERE REQUEST_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{requestId}, new RowMapper<AcquisitionRequestDTO>() {
            @Override
            public AcquisitionRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AcquisitionRequestDTO request = new AcquisitionRequestDTO();
                request.setRequestId(rs.getInt("REQUEST_ID"));
                request.setBookTitle(rs.getString("BOOK_TITLE"));
                request.setAuthorName(rs.getString("AUTHOR_NAME"));
                request.setPublisherName(rs.getString("PUBLISHER_NAME"));
                request.setGenreFullName(rs.getString("GENRE_FULLNAME"));
                request.setRequestDate(rs.getDate("REQUEST_DATE"));
                request.setSummary(rs.getString("SUMMARY"));
                request.setRequestStatus(rs.getString("REQUEST_STATUS"));
                return request;
            }
        });
    }

    // 도서 획득 요청 상태 업데이트
    public void updateRequestStatus(Integer requestId, String requestStatus) {
        String sql = "UPDATE ACQUISITION_REQUESTS SET REQUEST_STATUS = ? WHERE REQUEST_ID = ?";
        jdbcTemplate.update(sql, requestStatus, requestId);
    }

    // 도서 획득 요청 삭제
    public void deleteAcquisitionRequest(Integer requestId) {
        String sql = "DELETE FROM ACQUISITION_REQUESTS WHERE REQUEST_ID = ?";
        jdbcTemplate.update(sql, requestId);
    }
}
