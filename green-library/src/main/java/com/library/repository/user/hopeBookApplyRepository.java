package com.library.repository.user;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class hopeBookApplyRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void makeWish(String userId, String wishTitle, String wishAuthor, String wishPublisher, Date wishPublication, int wishPrice, String wishIsbn) {
		String sql = "INSERT INTO wishlists (wishlist_id, user_id, wish_date, wish_title, wish_author, wish_publisher, wish_publication, wish_price, wish_isbn)"
				+ " VALUES (wishlist_idx.NEXTVAL, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, userId, wishTitle, wishAuthor, wishPublisher, wishPublication, wishPrice, wishIsbn);
	}
}
