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
		String sql = "SELECT b.img, b.title, b.isbn, a.author_name, r.rent_history, r.return_date "
				+ "From rents r "
				+ "JOIN books b On b.book_id=r.book_id "	
				+ "JOIN authors a ON b.author_id = a.author_id "
				+ "WHERE user_id ?";
				
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
				return extension;
			}
		}, userId);
		
	}
	
	public void makeExtension(String userId) {
		String sql = "UPDATE rents "
				+ "set return_date = return_date + INTERVAL '14' DAY "
				+ "where user_id = ?";
		jdbcTemplate.update(sql, userId);
	}
}
