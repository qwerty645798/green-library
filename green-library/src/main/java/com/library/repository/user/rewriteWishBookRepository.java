package com.library.repository.user;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.rewriteWishBookDto;

@Repository
public class rewriteWishBookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public rewriteWishBookDto findByWishlistId(int wishlistId) {
		String sql ="SELECT user_id, wishlist_id, wish_date, wish_title, wish_author, wish_publisher, wish_publication, wish_price, wish_isbn "
				+ "FROM wishlists "
				+ "WHERE wishlist_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<rewriteWishBookDto>() {
			@Override
			public rewriteWishBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				rewriteWishBookDto book = new rewriteWishBookDto();
                book.setUserId(rs.getString("user_id"));
                book.setWishlistId(rs.getInt("wishlist_id"));
                book.setWishDate(rs.getDate("wish_date"));
                book.setWishTitle(rs.getString("wish_title"));
                book.setWishAuthor(rs.getString("wish_author"));
                book.setWishPublisher(rs.getString("wish_publisher"));
                book.setWishPublication(rs.getDate("wish_publication"));
                book.setWishIsbn(rs.getString("wish_isbn"));
                book.setWishPrice(rs.getInt("wish_price"));
                                
				return book;
			}
		}, wishlistId);				
	}
	
	// 위리아이디, 유저아이디 기준 업데이트
	public void updateWish(String wishTitle, String wishAuthor, String wishPublisher, Date wishPublication, int wishPrice, String wishIsbn, int wishlistId, String userId) {
		String sql = "UPDATE wishlists "
		           + "SET wish_title = ?, wish_author = ?, wish_publisher = ?, wish_publication = ?, wish_price = ?, wish_isbn = ? "
		           + "WHERE wishlist_id = ? AND user_id = ?";
		jdbcTemplate.update(sql, wishTitle, wishAuthor, wishPublisher, wishPublication, wishPrice, wishIsbn, wishlistId, userId);
	}
}
