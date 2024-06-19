package com.library.repository.admin;

import com.library.dto.admin._normal.InquiryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InquiryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ResultSet에서 RESPONSE_TF 값을 InquiryDTO의 responseTF 필드에 설정하는 메서드
    private static void setResponse(ResultSet rs, InquiryDTO inquiry) throws SQLException {
        String responseTfStr = rs.getString("RESPONSE_TF");
        Character responseTf = null;

        if (responseTfStr != null && !responseTfStr.isEmpty()) {
            responseTf = responseTfStr.charAt(0);
        }

        inquiry.setResponseTF(responseTf);
    }

    // 모든 문의 목록 조회
    public List<InquiryDTO> getAllInquiries() {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSE_TF " +
                "FROM INQUIRIES";
        return jdbcTemplate.query(sql, new RowMapper<InquiryDTO>() {
            @Override
            public InquiryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                InquiryDTO inquiry = new InquiryDTO();
                inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
                inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
                inquiry.setContents(rs.getString("CONTENTS"));
                inquiry.setUserId(rs.getString("USER_ID"));
                inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
                setResponse(rs, inquiry);
                return inquiry;
            }
        });
    }

    // 제목으로 문의 검색
    public List<InquiryDTO> searchByTitle(String keyword) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSE_TF " +
                "FROM INQUIRIES WHERE INQUIRY_TITLE LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%"}, new RowMapper<InquiryDTO>() {
            @Override
            public InquiryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                InquiryDTO inquiry = new InquiryDTO();
                inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
                inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
                inquiry.setContents(rs.getString("CONTENTS"));
                inquiry.setUserId(rs.getString("USER_ID"));
                inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
                setResponse(rs, inquiry);
                return inquiry;
            }
        });
    }

    // 내용으로 문의 검색
    public List<InquiryDTO> searchByContents(String keyword) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSE_TF " +
                "FROM INQUIRIES WHERE CONTENTS LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%"}, new RowMapper<InquiryDTO>() {
            @Override
            public InquiryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                InquiryDTO inquiry = new InquiryDTO();
                inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
                inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
                inquiry.setContents(rs.getString("CONTENTS"));
                inquiry.setUserId(rs.getString("USER_ID"));
                inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
                setResponse(rs, inquiry);
                return inquiry;
            }
        });
    }

    // 답변이 등록된 문의 목록 조회
    public List<InquiryDTO> findAnsweredInquiries() {
        String sql = "SELECT I.INQUIRY_ID, I.INQUIRY_TITLE, I.CONTENTS, I.USER_ID, I.INQUIRY_DATE, I.RESPONSE_TF " +
                "FROM INQUIRIES I JOIN INQUIRY_RESPONSE IR ON I.INQUIRY_ID = IR.INQUIRY_ID";
        return jdbcTemplate.query(sql, new RowMapper<InquiryDTO>() {
            @Override
            public InquiryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                InquiryDTO inquiry = new InquiryDTO();
                inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
                inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
                inquiry.setContents(rs.getString("CONTENTS"));
                inquiry.setUserId(rs.getString("USER_ID"));
                inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
                setResponse(rs, inquiry);
                return inquiry;
            }
        });
    }

    // 문의 상세 정보 조회
    public InquiryDTO findInquiryById(Integer inquiryId) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE " +
                "FROM INQUIRIES WHERE INQUIRY_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{inquiryId}, new RowMapper<InquiryDTO>() {
            @Override
            public InquiryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                InquiryDTO inquiry = new InquiryDTO();
                inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
                inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
                inquiry.setContents(rs.getString("CONTENTS"));
                inquiry.setUserId(rs.getString("USER_ID"));
                inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
                return inquiry;
            }
        });
    }

    // 문의 답변 등록
    public void writeResponse(Integer inquiryId, String responseContent, String adminId) {
        String sql = "INSERT INTO INQUIRY_RESPONSE (RESPONSE_ID, INQUIRY_ID, RESPONSE_DATE, RESPONSE_CONTENT, ADMIN_ID) " +
                "VALUES (RESPONSE.NEXTVAL, ?, SYSDATE, ?, ?)";
        jdbcTemplate.update(sql, inquiryId, responseContent, adminId);
    }

}
