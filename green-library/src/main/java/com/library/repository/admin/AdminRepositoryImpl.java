package com.library.repository.admin;

import com.library.dto.admin._normal.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private final JdbcTemplate jdbcTemplate;

    public AdminRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AdminDTO> allAdminManage() {
        String sql = "SELECT ADMIN_ID, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK FROM ADMINS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AdminDTO admin = new AdminDTO();
            admin.setAdminId(rs.getString("ADMIN_ID"));
            admin.setAdminPass(rs.getString("ADMIN_PASS"));
            admin.setAdminEmail(rs.getString("ADMIN_EMAIL"));
            admin.setGrantRank(rs.getInt("GRANT_RANK"));
            return admin;
        });
    }

    @Override
    public AdminDTO getMyInfo(String adminId) {
        String sql = "SELECT ADMIN_ID, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK FROM ADMINS WHERE ADMIN_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{adminId}, (rs, rowNum) -> {
            AdminDTO admin = new AdminDTO();
            admin.setAdminId(rs.getString("ADMIN_ID"));
            admin.setAdminPass(rs.getString("ADMIN_PASS"));
            admin.setAdminEmail(rs.getString("ADMIN_EMAIL"));
            admin.setGrantRank(rs.getInt("GRANT_RANK"));
            return admin;
        });
    }

    @Override
    public AdminDTO loginAdmin(String adminId, String adminPass) {
        String sql = "SELECT ADMIN_ID, ADMIN_PASS FROM ADMINS WHERE ADMIN_ID = ? AND ADMIN_PASS = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{adminId, adminPass}, (rs, rowNum) -> {
            AdminDTO admin = new AdminDTO();
            admin.setAdminId(rs.getString("ADMIN_ID"));
            admin.setAdminPass(rs.getString("ADMIN_PASS"));
            return admin;
        });
    }
}
