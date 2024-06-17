package com.library.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.dto.InitiativeBookDto;

@Repository
public class InitiativeBookRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
}
