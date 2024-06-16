package com.library.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RentHistoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	/*
	 * public List<RentHistory> findLoanHistoryByUserId(Long userId) { String sql =
	 * "?"; return jdbcTemplate.query(sql, new Object[]{userId}); }
	 */
}