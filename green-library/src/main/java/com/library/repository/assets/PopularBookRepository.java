package com.library.repository.assets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.assets.PopularBookDto;

@Repository
public class PopularBookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<PopularBookDto> findBookId() {
		String sql = "SELECT book_id, img, title, author_name, publisher_name, availability "
		           + "FROM ("
		           + "SELECT b.book_id, b.img, b.title, a.author_name, p.publisher_name, b.availability "
		           + "FROM books b "
		           + "JOIN authors a ON b.author_id = a.author_id "
		           + "JOIN publishers p ON b.publisher_id = p.publisher_id "
		           + "ORDER BY b.borrow_count DESC) "
		           + "WHERE ROWNUM <= 30";
		
		return jdbcTemplate.query(sql, new RowMapper<PopularBookDto>() {
			@Override
			public PopularBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				PopularBookDto book = new PopularBookDto();
                book.setBook_id(rs.getInt("book_id"));
                book.setImg(rs.getString("img"));
                book.setTitle(rs.getString("title"));
                book.setAuthorName(rs.getString("author_name"));
                book.setPublisherName(rs.getString("publisher_name"));
                book.setAvailability(rs.getString("availability"));  
                                
                if (book.getAvailability() != null) {
                    if (book.getAvailability().equals("1")) {
                        book.setAvailability("대출가능");
                    } else {
                        book.setAvailability("대출불가");
                    }
                } else {
                    book.setAvailability("알수없음");
                }
                
				return book;
			}
		});
	}
}
