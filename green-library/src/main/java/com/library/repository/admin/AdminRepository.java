package com.library.repository.admin;

import com.library.dto.admin._normal.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdminRepository {

    private final JdbcTemplate jdbcTemplate;

    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 모든 관리자 목록 조회
    public List<AdminDTO> allAdminManage() {
        String sql = "SELECT ADMIN_ID, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK FROM ADMINS";
        return jdbcTemplate.query(sql, new RowMapper<AdminDTO>() {
            @Override
            public AdminDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdminDTO admin = new AdminDTO();
                admin.setAdminId(rs.getString("admin_id"));
                admin.setAdminPass(rs.getString("admin_pass"));
                admin.setAdminEmail(rs.getString("admin_email"));
                admin.setGrantRank(rs.getInt("grant_rank"));
                return admin;
            }
        });
    }

    // 내 계정 정보 조회
    public AdminDTO getMyInfo(String adminId) {
        String sql = "SELECT ADMIN_ID, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK FROM ADMINS WHERE ADMIN_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{adminId}, (rs, rowNum) -> {
            AdminDTO admin = new AdminDTO();
            admin.setAdminId(rs.getString("admin_id"));
            admin.setAdminPass(rs.getString("admin_pass"));
            admin.setAdminEmail(rs.getString("admin_email"));
            admin.setGrantRank(rs.getInt("grant_rank"));
            return admin;
        });
    }

    // 관리자 로그인 확인
    public AdminDTO loginAdmin(String adminId, String adminPass) {
        String sql = "SELECT admin_id, admin_pass FROM ADMINS WHERE admin_id = ? AND admin_pass = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{adminId, adminPass}, new RowMapper<AdminDTO>() {
            @Override
            public AdminDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdminDTO admin = new AdminDTO();
                admin.setAdminId(rs.getString("admin_id"));
                admin.setAdminPass(rs.getString("admin_pass"));
                return admin;
            }
        });
    }
}
