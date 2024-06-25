package com.library.repository.assets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookReservationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void reserveBook(int bookId, String userId) {
		String sql = "INSERT INTO reservations (reservation_id, book_id, user_id, reservation_date) values(reservation_idx.nextval, ?, ?, current_date)";
		jdbcTemplate.update(sql, bookId, userId);
	}
	
	public void changeAvail(int bookId) {
		String sql = "UPDATE books " +
                "SET availability = 0 " +
                "WHERE book_id = ?";

		jdbcTemplate.update(sql, bookId);
	}
}
