package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.WishBookDto;

@Repository
public class WishBookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public WishBookDto findByWishId(int wishId) {
		String sql = "SELECT wishlist_id, complete, wish_date, wish_title, wish_isbn, wish_author, wish_price, wish_publisher, wish_publication "
                + "FROM wishlists "
                + "WHERE wishlist_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<WishBookDto>() {
			@Override
			public WishBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				WishBookDto book = new WishBookDto();
                book.setWishId(rs.getInt("wishlist_id"));
                book.setComplete(rs.getString("complete"));
                book.setWishDate(rs.getDate("wish_date"));
                book.setWishTitle(rs.getString("wish_title"));
                book.setWishIsbn(rs.getString("wish_isbn"));
                book.setWishAuthor(rs.getString("wish_author"));
                book.setWishPrice(rs.getInt("wish_price"));
                book.setWishPublisher(rs.getString("wish_publisher"));
                book.setWishPublication(rs.getDate("wish_publication"));
                
                if (book.getComplete() != null) {
                    if (book.getComplete().equals("W")) {
                        book.setComplete("심사대기");
                    } else if(book.getComplete().equals("N")) {
                        book.setComplete("심사탈락");
                    } else if(book.getComplete().equals("Y")){
                    	book.setComplete("심사통과");
                    }
                } else {
                    book.setComplete("알수없음");
                }
                
				return book;
			}
		}, wishId);
	}
}
