package com.library.repository.assets;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.assets.BookDetailDto;

@Repository
public class BookDetailRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BookDetailDto findByBookId(int bookId) {
		String sql = "SELECT books.title, books.isbn, authors.author_name, books.img, books.location, books.availability, books.summary, books.book_id "
                + "FROM books JOIN authors ON books.author_id = authors.author_id "
                + "WHERE books.book_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<BookDetailDto>() {
			@Override
			public BookDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookDetailDto book = new BookDetailDto();
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getInt("isbn"));
                book.setAuthorName(rs.getString("author_name"));
                book.setImg(rs.getString("img"));
                book.setLocation(rs.getString("location"));
                book.setAvailability(rs.getString("availability"));
                book.setSummary(rs.getString("summary"));
                book.setBookId(rs.getInt("book_id"));
                
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
		}, bookId); //요게 bookID 기준으로 데이터 셋하는거?
	}
	
	
}
