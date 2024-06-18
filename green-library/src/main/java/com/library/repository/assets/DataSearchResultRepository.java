package com.library.repository.assets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.assets.DataSearchResultDto;

@Repository
public class DataSearchResultRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<DataSearchResultDto> findBookId(String inputCategory, String inputText) {
		String sql = "SELECT b.book_id, b.img, b.title, b.availability, a.author_name, b.location, p.publisher_name, b.isbn, b.summary "
		           + "FROM books b "
		           + "JOIN authors a ON b.author_id = a.author_id "
		           + "JOIN publishers p ON b.publisher_id = p.publisher_id ";
		           
		if(inputCategory.equals("전체")) {
			sql += "WHERE b.title LIKE '%" + inputText + "%' " 
				   +"OR a.author_name LIKE '%" + inputText + "%' " 
                   +"OR p.publisher_name LIKE '%" + inputText + "%' " 
                   +"OR b.summary LIKE '%" + inputText + "%' ";
		}else if(inputCategory.equals("도서명")) {
			sql += "Where b.title LIKE '%" + inputText + "%' ";
		}else if(inputCategory.equals("저자")) {
			sql += "Where a.author_name LIKE '%" + inputText + "%' ";
		}else if(inputCategory.equals("출판사")) {
			sql += "Where p.publisher_name LIKE '%" + inputText + "%' ";
		}else if(inputCategory.equals("내용")) {
			sql += "Where b.summary LIKE '%" + inputText + "%' ";
		}
		           
		sql += "ORDER BY b.book_id";
		
		
		return jdbcTemplate.query(sql, new RowMapper<DataSearchResultDto>() {
			@Override
			public DataSearchResultDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				DataSearchResultDto book = new DataSearchResultDto();
                book.setBookId(rs.getInt("book_id"));
                book.setImg(rs.getString("img"));
                book.setTitle(rs.getString("title"));
                book.setAvailability(rs.getString("availability")); 
                book.setAuthorName(rs.getString("author_name"));
                book.setLocation(rs.getString("location"));
                book.setPublisherName(rs.getString("publisher_name")); 
                book.setIsbn(rs.getString("isbn"));
                book.setSummary(rs.getString("summary"));
                                
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
