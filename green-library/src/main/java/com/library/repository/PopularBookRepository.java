package com.library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.InitiativeBookDto;

@Repository
public class PopularBookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<InitiativeBookDto> findBookId() {
		String sql = "Select book_id, img from (select book_id, img from books order by publication_date desc) where rownum<= 6";
		
		return jdbcTemplate.query(sql, new RowMapper<InitiativeBookDto>() {
			@Override
			public InitiativeBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				InitiativeBookDto book = new InitiativeBookDto();
                book.setBook_id(rs.getInt("book_id"));
                book.setImg(rs.getString("img"));
				return book;
			}
		});
	}
}
