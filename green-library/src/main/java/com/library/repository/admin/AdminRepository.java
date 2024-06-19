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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 관리자 로그인 확인
    public AdminDTO loginAdmin(String adminId, String adminPass) {
        String sql = "SELECT admin_id, admin_pass FROM admins WHERE admin_id = ? AND admin_pass = ?";
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

    // 모든 관리자 목록 조회
    public List<AdminDTO> getAllAdmins() {
        String sql = "SELECT admin_id, admin_pass, grant_rank FROM admins";
        return jdbcTemplate.query(sql, new RowMapper<AdminDTO>() {
            @Override
            public AdminDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdminDTO admin = new AdminDTO();
                admin.setAdminId(rs.getString("admin_id"));
                admin.setAdminPass(rs.getString("admin_pass"));
                admin.setGrantRank(rs.getInt("grant_rank"));
                return admin;
            }
        });
    }
}
