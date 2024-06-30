package com.library.repository.admin;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.dto.admin._normal.AdminDTO;
import com.library.dto.admin.adminLogin.AdminLoginDTO;

@Transactional
@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private final JdbcTemplate jdbcTemplate;

    public AdminRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AdminDTO> allAdminManage() {
        String sql = "select ADMIN_NAME, ADMIN_ID, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK from ADMINS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AdminDTO admin = new AdminDTO();
            admin.setAdminName(rs.getString("ADMIN_NAME"));
            admin.setAdminId(rs.getString("ADMIN_ID"));
            admin.setAdminPass(rs.getString("ADMIN_PASS"));
            admin.setAdminEmail(rs.getString("ADMIN_EMAIL"));
            admin.setGrantRank(rs.getInt("GRANT_RANK"));
            return admin;
        });
    }

    @Override
    public AdminDTO getMyInfo(String adminId) {
        String sql = "SELECT ADMIN_NAME, ADMIN_ID, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK FROM ADMINS WHERE ADMIN_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{adminId}, (rs, rowNum) -> {
            AdminDTO admin = new AdminDTO();
            admin.setAdminName(rs.getString("ADMIN_NAME"));
            admin.setAdminId(rs.getString("ADMIN_ID"));
            admin.setAdminPass(rs.getString("ADMIN_PASS"));
            admin.setAdminEmail(rs.getString("ADMIN_EMAIL"));
            admin.setGrantRank(rs.getInt("GRANT_RANK"));
            return admin;
        });
    }


    @Override
    public AdminLoginDTO loginAdmin(String adminId) {
        String sql = "SELECT ADMIN_ID, ADMIN_PASS FROM ADMINS WHERE ADMIN_ID = ?";

        return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            AdminLoginDTO admin = new AdminLoginDTO();
            admin.setAdminID(rs.getString("ADMIN_ID"));
            admin.setAdminPass(rs.getString("ADMIN_PASS"));
            return admin;
        }, adminId);
    }
}
