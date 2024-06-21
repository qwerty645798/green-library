package com.library.repository.assets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.assets.InitiativeBookDto;

@Repository
public class InitiativeBookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<InitiativeBookDto> findBookId() {
		String sql = "Select book_id, img, title, author_name, publisher_name, publication_date, availability "
				+ "from (select b.book_id, b.img, b.title, a.author_name, p.publisher_name, b.publication_date, b.availability "
				+ "from books b "
				+ "Join authors a On a.author_id = b.author_id "
				+ "Join publishers p On p.publisher_id = b.publisher_id "				
				+ "order by b.publication_date desc) "
				+ "where rownum <= 24";
		
		return jdbcTemplate.query(sql, new RowMapper<InitiativeBookDto>() {
			@Override
			public InitiativeBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				InitiativeBookDto book = new InitiativeBookDto();
                book.setBook_id(rs.getInt("book_id"));
                book.setImg(rs.getString("img"));
                book.setTitle(rs.getString("title"));
                book.setAuthorName(rs.getString("author_name"));
                book.setPublisherName(rs.getString("publisher_name"));
                book.setPublicationDate(rs.getDate("publication_date"));
                book.setAvailability(rs.getString("availabiltiy"));
				return book;
			}
		});
	}
	
}
