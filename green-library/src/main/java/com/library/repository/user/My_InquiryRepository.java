package com.library.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class My_InquiryRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
}
