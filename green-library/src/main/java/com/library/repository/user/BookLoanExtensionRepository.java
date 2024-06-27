package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.BookLoanExtensionDto;

@Repository
public class BookLoanExtensionRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BookLoanExtensionDto> loanList(String userId) {
		String sql = "SELECT b.img, b.title, b.isbn, a.author_name, r.rent_history, r.return_date , b.book_id, r.returned "
				+ "From rents r "
				+ "JOIN books b On b.book_id=r.book_id "	
				+ "JOIN authors a ON b.author_id = a.author_id "
				+ "WHERE r.returned = 0 AND user_id = ?";
				
		return jdbcTemplate.query(sql, new RowMapper<BookLoanExtensionDto>(){
			@Override
			public BookLoanExtensionDto mapRow(ResultSet rs, int rowNum) throws SQLException{
				BookLoanExtensionDto extension = new BookLoanExtensionDto();
				extension.setImg(rs.getString("img"));
				extension.setTitle(rs.getString("title"));
				extension.setIsbn(rs.getString("isbn"));
				extension.setAuthorName(rs.getString("author_name"));
				extension.setRentHistory(rs.getDate("rent_history"));
				extension.setReturnDate(rs.getDate("return_date"));
				extension.setBookId(rs.getInt("book_id"));
				extension.setReturned(rs.getString("returned"));
				return extension;
			}
		}, userId);
		
	}
	
	public int rentCountByUserId(String userId) {
		String sql = "SELECT count(*) "
				+ "FROM rents "
				+ "where user_id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, userId);
	}
	
	
	public void makeExtension(int bookId) {
		String sql = "UPDATE rents "
				+ "set return_date = return_date + INTERVAL '14' DAY "
				+ "where book_id = ?";
		jdbcTemplate.update(sql, bookId);
	}
}
