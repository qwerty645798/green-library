package com.library.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInquiryCreateRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void makeInquiry(String userId, String inquiryTitle, String contents) {
		String sql = "INSERT INTO inquiries (inquiry_id, user_id, inquiry_date, inquiry_title, contents) VALUES (inquiry_idx.NEXTVAL, ?, current_date, ?, ?)";
		jdbcTemplate.update(sql, userId, inquiryTitle, contents);
	}
	
	public void modifyInquiry(String inquiryTitle, String contents, String userId, String id) {
		String sql = "UPDATE inquiries SET inquiry_title = ?, contents = ? where user_id = ? and inquiry_id = ?";
		jdbcTemplate.update(sql, inquiryTitle, contents, userId, id);
	}
	
	public void deleteInquiry(String userId, String id) {
        String sql = "DELETE FROM inquiries WHERE user_id = ? and inquiry_id = ?";
        jdbcTemplate.update(sql, userId, id);
    }
}
