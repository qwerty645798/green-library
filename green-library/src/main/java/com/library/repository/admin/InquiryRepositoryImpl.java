package com.library.repository.admin;

import com.library.dto.admin._normal.InquiryDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class InquiryRepositoryImpl implements InquiryRepository {

    private final JdbcTemplate jdbcTemplate;

    public InquiryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ResultSet, RESPONSE TF 값을 InquiryDTO의 responseTF 필드에 설정하는 메서드
    private static void setResponse(ResultSet rs, InquiryDTO inquiry) throws SQLException {
        String responseTfStr = rs.getString("RESPONSETF");
        Character responseTf = null;

        if (responseTfStr != null && !responseTfStr.isEmpty()) {
            responseTf = responseTfStr.charAt(0);
        }

        inquiry.setResponseTF(responseTf);
    }

    // 모든 문의 목록 조회
    @Override
    public List<InquiryDTO> allInquiryManage() {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF " +
                "FROM INQUIRIES " +
                "ORDER BY INQUIRY_ID";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            InquiryDTO inquiry = new InquiryDTO();
            inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            inquiry.setContents(rs.getString("CONTENTS"));
            inquiry.setUserId(rs.getString("USER_ID"));
            inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
            setResponse(rs, inquiry);
            return inquiry;
        });
    }

//    전체에서 조회
    @Override
    public List<InquiryDTO> findInquiryByTotal(String total) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF " +
                "FROM INQUIRIES WHERE INQUIRY_TITLE LIKE ? OR CONTENTS LIKE ? " +
                "ORDER BY INQUIRY_ID";
        String queryParam = "%" + total + "%";

        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            ps.setString(2, queryParam);
            return ps;
        }, (rs, rowNum) -> {
            InquiryDTO inquiry = new InquiryDTO();
            inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            inquiry.setContents(rs.getString("CONTENTS"));
            inquiry.setUserId(rs.getString("USER_ID"));
            inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
            setResponse(rs, inquiry);
            return inquiry;
        });
    }

    // 제목으로 문의 검색
    @Override
    public List<InquiryDTO> findInquiryByTitle(String keyword) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF " +
                "FROM INQUIRIES WHERE INQUIRY_TITLE LIKE ? " +
                "ORDER BY INQUIRY_ID";
        String queryParam = "%" + keyword + "%";

        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
            InquiryDTO inquiry = new InquiryDTO();
            inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            inquiry.setContents(rs.getString("CONTENTS"));
            inquiry.setUserId(rs.getString("USER_ID"));
            inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
            setResponse(rs, inquiry);
            return inquiry;
        });
    }

    // 내용으로 문의 검색
    @Override
    public List<InquiryDTO> findInquiryByContents(String keyword) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF " +
                "FROM INQUIRIES WHERE CONTENTS LIKE ? " +
                "ORDER BY INQUIRY_ID";
        String queryParam = "%" + keyword + "%";

        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
            InquiryDTO inquiry = new InquiryDTO();
            inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            inquiry.setContents(rs.getString("CONTENTS"));
            inquiry.setUserId(rs.getString("USER_ID"));
            inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
            setResponse(rs, inquiry);
            return inquiry;
        });
    }

    // 답변이 등록된 문의 목록 조회
    @Override
    public List<InquiryDTO> findAnsweredInquiry() {
        String sql = "SELECT I.INQUIRY_ID, I.INQUIRY_TITLE, I.CONTENTS, I.USER_ID, I.INQUIRY_DATE, I.RESPONSETF " +
                "FROM INQUIRIES I JOIN INQUIRY_RESPONSES IR ON I.INQUIRY_ID = IR.INQUIRY_ID " +
                "ORDER BY INQUIRY_ID";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            InquiryDTO inquiry = new InquiryDTO();
            inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            inquiry.setContents(rs.getString("CONTENTS"));
            inquiry.setUserId(rs.getString("USER_ID"));
            inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
            setResponse(rs, inquiry);
            return inquiry;
        });
    }

    // 문의 상세 정보 조회
    @Override
    public InquiryDTO getInquiryById(Integer inquiryId) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE " +
                "FROM INQUIRIES WHERE INQUIRY_ID = ? " +
                "ORDER BY INQUIRY_ID";
        return jdbcTemplate.query(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, inquiryId);
            return preparedStatement;
        }, rs -> {
            InquiryDTO inquiry = new InquiryDTO();
            inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            inquiry.setContents(rs.getString("CONTENTS"));
            inquiry.setUserId(rs.getString("USER_ID"));
            inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
            return inquiry;
        });
    }

    // 문의 답변 등록
    @Override
    public void createInquiry(Integer inquiryId, String responseContent, String adminId) {
        String sql = "INSERT INTO INQUIRY_RESPONSES (RESPONSE_ID, INQUIRY_ID, RESPONSE_DATE, RESPONSE_CONTENT, ADMIN_ID) " +
                "VALUES (RESPONSE_IDX.NEXTVAL, ?, SYSDATE, ?, ?)";
        jdbcTemplate.update(sql, inquiryId, responseContent, adminId);
    }

    //    삭제
    @Override
    public void deleteInquiry(int id) {
        String sql = "DELETE FROM INQUIRIES\n" +
                "WHERE INQUIRY_ID = ?;";
        jdbcTemplate.update(sql, id);
    }

    // 이전 제목 조회
    @Override
    public String previousInquiry(int inquiryId) {
        String sql = "SELECT INQUIRY_TITLE FROM (SELECT INQUIRY_TITLE, ROWNUM AS rnum FROM INQUIRIES WHERE INQUIRY_ID < ? ORDER BY INQUIRY_ID DESC) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, String.class, inquiryId);
    }

    // 다음 제목 조회
    @Override
    public String nextInquiry(int inquiryId) {
        String sql = "SELECT INQUIRY_TITLE FROM (SELECT INQUIRY_TITLE, ROWNUM AS rnum FROM INQUIRIES WHERE INQUIRY_ID > ? ORDER BY INQUIRY_ID) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, String.class, inquiryId);
    }
}
