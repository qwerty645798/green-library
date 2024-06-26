package com.library.repository.admin;

import com.library.dto.admin._normal.AdminDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Transactional
@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private final JdbcTemplate jdbcTemplate;

    public AdminRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AdminDTO> allAdminManage() {
        String sql = "select ADMIN_ID, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK from ADMINS";
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
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, adminId);
            return ps;
        }, rs -> {
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

        try {
            return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
                AdminDTO admin = new AdminDTO();
                admin.setAdminId(rs.getString("ADMIN_ID"));
                admin.setAdminPass(rs.getString("ADMIN_PASS"));
                return admin;
            }, adminId, adminPass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
