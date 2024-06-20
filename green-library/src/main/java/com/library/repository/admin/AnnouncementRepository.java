package com.library.repository.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementRepository {

    private final JdbcTemplate jdbcTemplate;

    public AnnouncementRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 모든 공지사항 목록 조회
    public List<AnnouncementDTO> allAnnounceManage() {
        String sql = "SELECT ANNOUNCEMENT_ID, ADNNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILE_NAME, " + "(SELECT COUNT(*) FROM ANNOUNCEMENT) AS total_count FROM ANNOUNCEMENTS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AnnouncementDTO announce = new AnnouncementDTO();
            announce.setAnnouncementId(rs.getInt("announcement_id"));
            announce.setAnnounceTitle(rs.getString("announce_title"));
            announce.setContents(rs.getString("contents"));
            announce.setWriterId(rs.getString("writer_id"));
            announce.setWriteDate(rs.getDate("write_date"));
            announce.setFileName(rs.getString("file_name"));
            return announce;
        });
    }

    // 제목으로 공지사항 검색
    public List<AnnouncementDTO> findAnnounceByTitle(String title) {
        String sql = "SELECT ANNOUNCEMENT_ID, ADNNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILE_NAME, " + "(SELECT COUNT(*) FROM ANNOUNCEMENT) AS total_count FROM ANNOUNCEMENTS WHERE ADNNOUNCE_TITLE LIKE ?";
        String queryParam = "%" + title + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
            AnnouncementDTO announce = new AnnouncementDTO();
            announce.setAnnouncementId(rs.getInt("announcement_id"));
            announce.setAnnounceTitle(rs.getString("announce_title"));
            announce.setContents(rs.getString("contents"));
            announce.setWriterId(rs.getString("writer_id"));
            announce.setWriteDate(rs.getDate("write_date"));
            announce.setFileName(rs.getString("file_name"));
            return announce;
        });
    }

    // 내용으로 공지사항 검색
    public List<AnnouncementDTO> findAnnounceByContents(String contents) {
        String sql = "SELECT ANNOUNCEMENT_ID, ADNNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILE_NAME, " + "(SELECT COUNT(*) FROM ANNOUNCEMENT) AS total_count FROM ANNOUNCEMENTS WHERE CONTENTS LIKE ?";
        String queryParam = "%" + contents + "%";
        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
            AnnouncementDTO announce = new AnnouncementDTO();
            announce.setAnnouncementId(rs.getInt("announcement_id"));
            announce.setAnnounceTitle(rs.getString("announce_title"));
            announce.setContents(rs.getString("contents"));
            announce.setWriterId(rs.getString("writer_id"));
            announce.setWriteDate(rs.getDate("write_date"));
            announce.setFileName(rs.getString("file_name"));
            return announce;
        });
    }

    // 공지사항 생성
    public void createAnnounce(AnnouncementDTO announcement) {
        String sql = "INSERT INTO ANNOUNCEMENTS (ANNOUNCEMENT_ID, ADNNOUNCE_TITLE, WRITER_ID, WRITE_DATE, CONTENTS, FILE_NAME) " + "VALUES (ANNOUNCEMENT.NEXTVAL, ?, ?, SYSDATE, ?, ?)";
        jdbcTemplate.update(sql, announcement.getAnnounceTitle(), announcement.getWriterId(), announcement.getContents(), announcement.getFileName());
    }

    // 공지사항 수정
    public void updateAnnounce(AnnouncementDTO announcement) {
        String sql = "UPDATE ANNOUNCEMENTS SET ADNNOUNCE_TITLE = ?, CONTENTS = ?, FILE_NAME = ? WHERE ANNOUNCEMENT_ID = ?";
        jdbcTemplate.update(sql, announcement.getAnnounceTitle(), announcement.getContents(), announcement.getFileName(), announcement.getAnnouncementId());
    }

    // 공지사항 삭제
    public void deleteAnnounce(int announceId) {
        String sql = "DELETE FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID = ?";
        jdbcTemplate.update(sql, announceId);
    }

    // 특정 공지사항 조회
    public AnnouncementDTO getAnnounceById(int announceId) {
        String sql = "SELECT ANNOUNCEMENT_ID, ADNNOUNCE_TITLE, ADMIN_ID, WRITE_DATE, VIEW_COUNT, CONTENTS, FILE_NAME " + "FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{announceId}, (rs, rowNum) -> {
            AnnouncementDTO announce = new AnnouncementDTO();
            announce.setAnnouncementId(rs.getInt("announcement_id"));
            announce.setAnnounceTitle(rs.getString("announce_title"));
            announce.setContents(rs.getString("contents"));
            announce.setWriterId(rs.getString("admin_id"));
            announce.setWriteDate(rs.getDate("write_date"));
            announce.setViewCount(rs.getInt("view_count"));
            announce.setFileName(rs.getString("file_name"));
            return announce;
        });
    }

    // 이전 공지 제목 조회
    public String previousAnnounce(int announceId) {
        String sql = "SELECT ADNNOUNCE_TITLE FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID < ? ORDER BY ANNOUNCEMENT_ID DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{announceId}, String.class);
    }

    // 다음 공지 제목 조회
    public String nextAnnounce(int announceId) {
        String sql = "SELECT ADNNOUNCE_TITLE FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID > ? ORDER BY ANNOUNCEMENT_ID LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{announceId}, String.class);
    }
}
