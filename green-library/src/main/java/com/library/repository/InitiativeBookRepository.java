package com.library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.InitiativeBookDto;
import com.library.dto.UserDto;

@Repository
public class InitiativeBookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<InitiativeBookDto> findBookId(String image) {
		String sql = "Select book_id, img from books order by date desc limit 6 ";
		List<String> list = new ArrayList<String>();
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<InitiativeBookDto>() {
			@Override
			public InitiativeBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				InitiativeBookDto dto = new InitiativeBookDto();
                dto.setBook_id(rs.getInt("book_id"));
                dto.setImg(rs.getString("img"));
                list.add(dto);
				return dto;
			}
		}, image);
	}
	
}
