package com.library.repository.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.service.admin.AnnounceServiceImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

@Transactional
@Repository
public class AnnouncementRepositoryImpl implements AnnouncementRepository {

    private static final Logger logger = LoggerFactory.getLogger(AnnounceServiceImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public AnnouncementRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 모든 공지사항 목록 조회
    public List<AnnouncementDTO> allAnnounceManage() {
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILENAME as FILE_NAME, " +
                "(SELECT COUNT(*) FROM ANNOUNCEMENTS) AS total_count FROM ANNOUNCEMENTS " + "ORDER BY ANNOUNCEMENT_ID";
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

    @Override
    public List<AnnouncementDTO> findAnnounceByTotal(String total) {
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILENAME, " +
                "(SELECT COUNT(*) FROM ANNOUNCEMENTS) AS total_count " +
                "FROM ANNOUNCEMENTS " +
                "WHERE ANNOUNCE_TITLE LIKE ? OR CONTENTS LIKE ? " +
                "ORDER BY ANNOUNCEMENT_ID";
        String queryParam = "%" + total + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            ps.setString(2, queryParam);
            return ps;
        }, (rs, rowNum) -> {
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
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILENAME, " + "(SELECT COUNT(*) FROM ANNOUNCEMENTS) AS total_count " + "FROM ANNOUNCEMENTS WHERE ANNOUNCE_TITLE LIKE ? " + "ORDER BY ANNOUNCEMENT_ID";
        String queryParam = "%" + title + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
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
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, CONTENTS, WRITER_ID, WRITE_DATE, FILENAME, " + "(SELECT COUNT(*) FROM ANNOUNCEMENTS) AS total_count FROM ANNOUNCEMENTS WHERE CONTENTS LIKE ? " + "ORDER BY ANNOUNCEMENT_ID";
        String queryParam = "%" + contents + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
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
        String sql = "INSERT INTO ANNOUNCEMENTS (ANNOUNCEMENT_ID, ANNOUNCE_TITLE, WRITER_ID, WRITE_DATE, CONTENTS, FILENAME) " +
                "VALUES (ANNOUNCE_IDX.NEXTVAL, ?, ?, SYSDATE, ?, ?)";

        try {
            jdbcTemplate.update(sql, announcement.getAnnounceTitle(), announcement.getWriterId(),
                    announcement.getContents(), announcement.getFileName());
        } catch (Exception e) {
            // IOException이 발생할 경우 여기서 처리
            logger.error("파일 업로드 중 오류 발생: {}", e.getMessage());
            // 다른 예외 처리 로직 추가 가능
            throw new RuntimeException("파일 업로드 중 오류 발생", e); // 예외 다시 던지기
        }
    }

    @Override
    public void createAnnounceWithoutFile(String announceTitle, String adminId, String announceContent) {
        String sql = "INSERT INTO ANNOUNCEMENTS (ANNOUNCEMENT_ID, ANNOUNCE_TITLE, WRITER_ID, WRITE_DATE, CONTENTS, FILENAME) " +
                "VALUES (ANNOUNCE_IDX.NEXTVAL, ?, ?, SYSDATE, ?, 'NULL')";
        try {
            jdbcTemplate.update(sql, announceTitle, adminId, announceContent);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createAnnounce(String announceTitle, String adminId , String announceContent, MultipartFile file) {
        String sql = "INSERT INTO ANNOUNCEMENTS (ANNOUNCEMENT_ID, ANNOUNCE_TITLE, WRITER_ID, WRITE_DATE, CONTENTS, FILENAME) " +
                "VALUES (ANNOUNCE_IDX.NEXTVAL, ?, ?, SYSDATE, ?, ?)";
        try {
            jdbcTemplate.update(sql, announceTitle, adminId, announceContent, file.getOriginalFilename());
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

//    수정
    @Override
    public void updateAnnounce(String announceTitle, String adminId, String announceContent, MultipartFile file) {
        String sql = "UPDATE ANNOUNCEMENTS SET ANNOUNCE_TITLE = ?, CONTENTS = ?, FILENAME = ? WHERE ANNOUNCEMENT_ID = ?";
        jdbcTemplate.update(sql, announceTitle, announceContent, file.getOriginalFilename(), adminId);
        System.out.println(announceTitle);
        System.out.println(adminId);
        System.out.println(announceContent);
        System.out.println(file);
    }

    @Override
    public void updateAnnounceWithoutFile(String announceTitle, String adminId, String announceContent, String aNull) {
        String sql = "UPDATE ANNOUNCEMENTS SET ANNOUNCE_TITLE = ?, CONTENTS = ?, FILENAME = ? WHERE ANNOUNCEMENT_ID = ?";
        jdbcTemplate.update(sql, announceTitle, announceContent, aNull, adminId);
        System.out.println(announceTitle);
        System.out.println(adminId);
        System.out.println(announceContent);
        System.out.println(aNull);
    }

    // 공지사항 삭제
    public void deleteAnnounce(List<String> announceId) {
        String sql = "DELETE FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID IN (";
        for (int i = 0; i < announceId.size(); i++) {
            sql += announceId.get(i);
            if (i < announceId.size() - 1) {
                sql += ",";
            }
        }
        sql += ")";
        jdbcTemplate.update(sql);
    }

    // 특정 공지사항 조회
    public AnnouncementDTO getAnnounceById(int announceId) {
        String sql = "SELECT ANNOUNCEMENT_ID, ANNOUNCE_TITLE, ADMIN_ID, WRITE_DATE, VIEW_COUNT, CONTENTS, FILENAME " +
                "FROM ANNOUNCEMENTS " +
                "JOIN ADMINS ON ANNOUNCEMENTS.WRITER_ID = ADMINS.ADMIN_ID " +
                "WHERE ANNOUNCEMENT_ID = ?";

        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, announceId);
            return ps;
        }, rs -> {
            if (rs.next()) {
                AnnouncementDTO announce = new AnnouncementDTO();
                announce.setAnnouncementId(rs.getInt("announcement_id"));
                announce.setAnnounceTitle(rs.getString("announce_title"));
                announce.setContents(rs.getString("contents"));
                announce.setWriterId(rs.getString("admin_id"));
                announce.setWriteDate(rs.getDate("write_date"));
                announce.setViewCount(rs.getInt("view_count"));
                announce.setFileName(rs.getString("filename"));
                return announce;
            } else {
                return null; // announceId에 해당하는 데이터가 없는 경우
            }
        });
    }

    // 이전 공지 제목 조회
    public String previousAnnounce(int announceId) {
        String sql = "SELECT ANNOUNCE_TITLE FROM (SELECT ANNOUNCE_TITLE, ROWNUM AS rnum FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID < :announcementId ORDER BY ANNOUNCEMENT_ID DESC) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, String.class, announceId);
    }

    // 다음 공지 제목 조회
    public String nextAnnounce(int announceId) {
        String sql = "SELECT ANNOUNCE_TITLE FROM (SELECT ANNOUNCE_TITLE, ROWNUM AS rnum FROM ANNOUNCEMENTS WHERE ANNOUNCEMENT_ID > :announcementId ORDER BY ANNOUNCEMENT_ID) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, String.class, announceId);
    }
}
