package com.library.repository.admin;

import com.library.dto.admin._normal.InquiryDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InquiryRepositoryImpl implements InquiryRepository {

    private final JdbcTemplate jdbcTemplate;

    public InquiryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void setResponse(ResultSet rs, InquiryDTO inquiry) throws SQLException {
        String responseTfStr = rs.getString("RESPONSETF");
        Character responseTf = null;

        if (responseTfStr != null && !responseTfStr.isEmpty()) {
            responseTf = responseTfStr.charAt(0);
        }

        inquiry.setResponseTF(responseTf);
    }

    @Override
    public List<InquiryDTO> findAllInquiries() {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES ORDER BY INQUIRY_ID";
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

    @Override
    public List<InquiryDTO> findInquiriesByResponseTF(boolean responseTF) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES WHERE RESPONSETF = ? ORDER BY INQUIRY_ID";
        return jdbcTemplate.query(sql, new Object[]{responseTF ? '1' : '0'}, (rs, rowNum) -> {
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

    @Override
    public List<InquiryDTO> findInquiriesByTotal(String total) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES WHERE INQUIRY_TITLE LIKE ? OR CONTENTS LIKE ? ORDER BY INQUIRY_ID";
        String queryParam = "%" + total + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam, queryParam}, (rs, rowNum) -> {
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

    @Override
    public List<InquiryDTO> findInquiriesByTotalAndResponseTF(String total, boolean responseTF) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES WHERE (INQUIRY_TITLE LIKE ? OR CONTENTS LIKE ?) AND RESPONSETF = ? ORDER BY INQUIRY_ID";
        String queryParam = "%" + total + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam, queryParam, responseTF ? '1' : '0'}, (rs, rowNum) -> {
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

    @Override
    public List<InquiryDTO> findInquiriesByTitle(String keyword) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES WHERE INQUIRY_TITLE LIKE ? ORDER BY INQUIRY_ID";
        String queryParam = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
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

    @Override
    public List<InquiryDTO> findInquiriesByTitleAndResponseTF(String keyword, boolean responseTF) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES WHERE INQUIRY_TITLE LIKE ? AND RESPONSETF = ? ORDER BY INQUIRY_ID";
        String queryParam = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam, responseTF ? '1' : '0'}, (rs, rowNum) -> {
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

    @Override
    public List<InquiryDTO> findInquiriesByContents(String keyword) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES WHERE CONTENTS LIKE ? ORDER BY INQUIRY_ID";
        String queryParam = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
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

    @Override
    public List<InquiryDTO> findInquiriesByContentsAndResponseTF(String keyword, boolean responseTF) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF FROM INQUIRIES WHERE CONTENTS LIKE ? AND RESPONSETF = ? ORDER BY INQUIRY_ID";
        String queryParam = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam, responseTF ? '1' : '0'}, (rs, rowNum) -> {
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
//    @Override
//    public List<InquiryDTO> findAnsweredInquiry() {
//        String sql = "SELECT I.INQUIRY_ID, I.INQUIRY_TITLE, I.CONTENTS, I.USER_ID, I.INQUIRY_DATE, I.RESPONSETF " +
//                "FROM INQUIRIES I JOIN INQUIRY_RESPONSES IR ON I.INQUIRY_ID = IR.INQUIRY_ID " +
//                "ORDER BY INQUIRY_ID";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            InquiryDTO inquiry = new InquiryDTO();
//            inquiry.setInquiryId(rs.getInt("INQUIRY_ID"));
//            inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
//            inquiry.setContents(rs.getString("CONTENTS"));
//            inquiry.setUserId(rs.getString("USER_ID"));
//            inquiry.setInquiryDate(rs.getDate("INQUIRY_DATE"));
//            setResponse(rs, inquiry);
//            return inquiry;
//        });
//    }

    // 문의 상세 정보 조회 및 답변 번호 포함
    @Override
    public InquiryDTO getInquiryById(int inquiryId) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE, CONTENTS, USER_ID, INQUIRY_DATE, RESPONSETF " +
                "FROM INQUIRIES WHERE INQUIRY_ID = ? ";

        // 질의 정보 조회
        return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            InquiryDTO inquiryDTO = new InquiryDTO();
            inquiryDTO.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiryDTO.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            inquiryDTO.setContents(rs.getString("CONTENTS"));
            inquiryDTO.setUserId(rs.getString("USER_ID"));
            inquiryDTO.setInquiryDate(rs.getDate("INQUIRY_DATE"));
            setResponse(rs, inquiryDTO);
            return inquiryDTO;
        }, inquiryId);
    }

    // 문의 답변 등록
    @Override
    public void createInquiry(Integer inquiryId, String responseContent, String adminId) {
        // 삽입 쿼리
        String insertSql = "INSERT INTO INQUIRY_RESPONSES (RESPONSE_ID, INQUIRY_ID, RESPONSE_DATE, RESPONSE_CONTENT, ADMIN_ID) " +
                "VALUES (RESPONSE_IDX.NEXTVAL, ?, SYSDATE, ?, ?)";

        // 업데이트 쿼리
        String updateSql = "UPDATE INQUIRIES SET RESPONSETF = 1 WHERE INQUIRY_ID = ?";

        // 실행
        jdbcTemplate.update(insertSql, inquiryId, responseContent, adminId);
        jdbcTemplate.update(updateSql, inquiryId);

    }

    //    삭제
    @Override
    public void deleteInquiry(List<String> userIds) {
        String sql = "DELETE FROM INQUIRIES " +
                "WHERE INQUIRY_ID IN (";
        for (int i = 0; i < userIds.size(); i++) {
            sql += "'" + userIds.get(i) + "'";
            if (i < userIds.size() - 1) {
                sql += ",";
            }
        }

        sql += ")";

        jdbcTemplate.update(sql);
    }

    // 이전 제목 조회
    @Override
    public InquiryDTO getPreviousInquiry(int inquiryId) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE FROM (SELECT INQUIRY_ID, INQUIRY_TITLE, ROW_NUMBER() OVER (ORDER BY INQUIRY_ID DESC) AS rnum FROM INQUIRIES WHERE INQUIRY_ID < ?) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            InquiryDTO inquiryDTO = new InquiryDTO();
            inquiryDTO.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiryDTO.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            return inquiryDTO;
        }, inquiryId);
    }

    @Override
    public InquiryDTO getNextInquiry(int inquiryId) {
        String sql = "SELECT INQUIRY_ID, INQUIRY_TITLE FROM (SELECT INQUIRY_ID, INQUIRY_TITLE, RESPONSETF, ROW_NUMBER() OVER (ORDER BY INQUIRY_ID ASC) AS rnum FROM INQUIRIES WHERE INQUIRY_ID > ?) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            InquiryDTO inquiryDTO = new InquiryDTO();
            inquiryDTO.setInquiryId(rs.getInt("INQUIRY_ID"));
            inquiryDTO.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
            return inquiryDTO;
        }, inquiryId);
    }
}
