package com.library.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInquiryCreateRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void makeInquiry(String userId, String inquiryTitle, String contents) {
		String sql = "INSERT INTO inquiries (user_id, inquiry_date, inquiry_title, contents ) values(?, current_date, ?, ?)";
		jdbcTemplate.update(sql, userId, inquiryTitle, contents);
	}
	
}