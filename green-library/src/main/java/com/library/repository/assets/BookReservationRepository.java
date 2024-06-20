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
	
	public void reserveBook2(String bookId, String userId) {
		String sql = "UPDATE books b "
				+ "Join reservations r On b.book_id = r.book_id "
				+ "Join users u On r.user_id = u.user_id "
				+ "set b.availability = 0"
				+ "where r.user_id = ? and b.book_id = ?";
		jdbcTemplate.update(sql, userId, bookId);
	}
}
