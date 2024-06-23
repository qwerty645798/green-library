package com.library.repository.assets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookReservationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void reserveBook(String bookId, String userId) {
		String sql = "INSERT INTO reservations (book_id, user_id, reservation_date) values(?, ?, current_date)";
		jdbcTemplate.update(sql, bookId, userId);
	}
	
	
}
