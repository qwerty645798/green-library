package com.library.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.dto.LoginDTO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HttpServletRequest request;

    private static final String SQL = "SELECT u.user_id AS id, u.user_pass AS password, NULL AS grant_rank " +
            "FROM users u WHERE u.user_id = ? " +
            "UNION ALL " +
            "SELECT a.admin_id AS id, a.admin_pass AS password, a.grant_rank " +
            "FROM admins a WHERE a.admin_id = ?";

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        List<LoginDTO> results = jdbcTemplate.query(SQL, new RowMapper<LoginDTO>() {
            @Override
            public LoginDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LoginDTO loginDTO = new LoginDTO();
                loginDTO.setId(rs.getString("id"));
                loginDTO.setPassword(rs.getString("password"));
                Integer grantRank = rs.getObject("grant_rank") != null ? rs.getInt("grant_rank") : null;
                loginDTO.setGrantRank(grantRank);
                return loginDTO;
            }
        }, id, id);

        if (results.isEmpty()) {
            throw new UsernameNotFoundException("User not found with id: " + id);
        }

        // Referer 헤더를 사용하여 요청이 관리자 페이지에서 왔는지 확인
        String referer = request.getHeader("Referer");
        boolean isAdminRequest = referer != null && referer.contains("/admin");

        // 관리자와 사용자 계정을 구분
        LoginDTO selectedAccount = null;
        if (isAdminRequest) {
            selectedAccount = results.stream()
                    .filter(account -> account.getGrantRank() != null)
                    .findFirst()
                    .orElseThrow(() -> new UsernameNotFoundException("Admin not found with id: " + id));
        } else {
            selectedAccount = results.stream()
                    .filter(account -> account.getGrantRank() == null)
                    .findFirst()
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        if (selectedAccount.getGrantRank() != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return User
                .withUsername(selectedAccount.getId())
                .password(selectedAccount.getPassword())
                .authorities(authorities)
                .build();
    }
}