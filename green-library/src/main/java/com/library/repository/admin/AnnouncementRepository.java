package com.library.repository.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AnnouncementRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 모든 공지사항 목록 조회
    public List<AnnouncementDTO> getAllAnnouncements() {
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILE_NAME " +
                "FROM ANNOUNCEMENTS";
        return jdbcTemplate.query(sql, new RowMapper<AnnouncementDTO>() {
            @Override
            public AnnouncementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AnnouncementDTO announcement = new AnnouncementDTO();
                announcement.setAnnouncementId(rs.getInt("ANNOUNCEMENT_ID"));
                announcement.setAnnounceTitle(rs.getString("ANNOUNCE_TITLE"));
                announcement.setContents(rs.getString("CONTENTS"));
                announcement.setWriterId(rs.getString("WRITER_ID"));
                announcement.setWriteDate(rs.getDate("WRITE_DATE"));
                announcement.setFileName(rs.getString("FILE_NAME"));
                return announcement;
            }
        });
    }

    // 제목으로 공지사항 검색
    public List<AnnouncementDTO> searchByTitle(String keyword) {
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILE_NAME " +
                "FROM ANNOUNCEMENTS WHERE ANNOUNCE_TITLE LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%"}, new RowMapper<AnnouncementDTO>() {
            @Override
            public AnnouncementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AnnouncementDTO announcement = new AnnouncementDTO();
                announcement.setAnnouncementId(rs.getInt("ANNOUNCEMENT_ID"));
                announcement.setAnnounceTitle(rs.getString("ANNOUNCE_TITLE"));
                announcement.setContents(rs.getString("CONTENTS"));
                announcement.setWriterId(rs.getString("WRITER_ID"));
                announcement.setWriteDate(rs.getDate("WRITE_DATE"));
                announcement.setFileName(rs.getString("FILE_NAME"));
                return announcement;
            }
        });
    }

    // 공지사항 내용으로 검색
    public List<AnnouncementDTO> searchByContents(String keyword) {
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILE_NAME " +
                "FROM ANNOUNCEMENTS WHERE CONTENTS LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%"}, new RowMapper<AnnouncementDTO>() {
            @Override
            public AnnouncementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AnnouncementDTO announcement = new AnnouncementDTO();
                announcement.setAnnouncementId(rs.getInt("ANNOUNCEMENT_ID"));
                announcement.setAnnounceTitle(rs.getString("ANNOUNCE_TITLE"));
                announcement.setContents(rs.getString("CONTENTS"));
                announcement.setWriterId(rs.getString("WRITER_ID"));
                announcement.setWriteDate(rs.getDate("WRITE_DATE"));
                announcement.setFileName(rs.getString("FILE_NAME"));
                return announcement;
            }
        });
    }

    // 공지사항 등록
    public void createAnnouncement(AnnouncementDTO announcementDTO) {
        String sql = "INSERT INTO ANNOUNCEMENTS (ANNOUNCEMENT_ID, ANNOUNCE_TITLE, WRITER_ID, WRITE_DATE, CONTENTS, FILE_NAME) " +
                "VALUES (ANNOUNCEMENT.NEXTVAL, ?, ?, SYSDATE, ?, ?)";
        jdbcTemplate.update(sql, announcementDTO.getAnnounceTitle(), announcementDTO.getWriterId(),
                announcementDTO.getContents(), announcementDTO.getFileName());
    }

    // 공지사항 수정
    public void updateAnnouncement(AnnouncementDTO announcementDTO) {
        String sql = "UPDATE ANNOUNCEMENTS SET ANNOUNCE_TITLE = ?, CONTENTS = ?, FILE_NAME = ? " +
                "WHERE ANNOUNCEMENT_ID = ?";
        jdbcTemplate.update(sql, announcementDTO.getAnnounceTitle(), announcementDTO.getContents(),
                announcementDTO.getFileName(), announcementDTO.getAnnouncementId());
    }

    // 공지사항 삭제
    public void deleteAnnouncement(Long announcementId) {
        String sql = "DELETE FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID = ?";
        jdbcTemplate.update(sql, announcementId);
    }

    // 공지사항 상세 정보 조회
    public AnnouncementDTO getAnnouncementById(Long announcementId) {
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILE_NAME " +
                "FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{announcementId}, new RowMapper<AnnouncementDTO>() {
            @Override
            public AnnouncementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AnnouncementDTO announcement = new AnnouncementDTO();
                announcement.setAnnouncementId(rs.getInt("ANNOUNCEMENT_ID"));
                announcement.setAnnounceTitle(rs.getString("ANNOUNCE_TITLE"));
                announcement.setContents(rs.getString("CONTENTS"));
                announcement.setWriterId(rs.getString("WRITER_ID"));
                announcement.setWriteDate(rs.getDate("WRITE_DATE"));
                announcement.setFileName(rs.getString("FILE_NAME"));
                return announcement;
            }
        });
    }

    // 이전 공지사항 제목 조회
    public String findPreviousAnnouncementTitle(Integer announcementId) {
        String sql = "SELECT ANNOUNCE_TITLE FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID < ? ORDER BY ANNOUNCEMENT_ID DESC";
        return jdbcTemplate.queryForObject(sql, new Object[]{announcementId}, String.class);
    }

    // 다음 공지사항 제목 조회
    public String findNextAnnouncementTitle(Integer announcementId) {
        String sql = "SELECT ANNOUNCE_TITLE FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID > ? ORDER BY ANNOUNCEMENT_ID ASC";
        return jdbcTemplate.queryForObject(sql, new Object[]{announcementId}, String.class);
    }
}
