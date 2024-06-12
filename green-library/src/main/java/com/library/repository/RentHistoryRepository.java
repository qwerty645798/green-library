package com.library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.model.RentHistory;

@Repository
public class RentHistoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	/*
	 * public List<RentHistory> findLoanHistoryByUserId(Long userId) { String sql =
	 * "?"; return jdbcTemplate.query(sql, new Object[]{userId}); }
	 */
}