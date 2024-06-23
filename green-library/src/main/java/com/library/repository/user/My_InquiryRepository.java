package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.My_InquiryDto;


@Repository
public class My_InquiryRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<My_InquiryDto> myInquiryList(String userId) {
		String sql = "SELECT inquiry_id, user_id, inquiry_date, inquiry_title, responserTF "
		           + "FROM inquiries "
		           + "Where user_id=?";
		           
		return jdbcTemplate.query(sql, new RowMapper<My_InquiryDto>() {
			@Override
			public My_InquiryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				My_InquiryDto inquiryList = new My_InquiryDto();
				inquiryList.setInquiryId(rs.getInt("inquiry_id"));
				inquiryList.setUserId(rs.getString("user_id"));
				inquiryList.setInquiryDate(rs.getDate("inquiry_date"));
				inquiryList.setInquiryTitle(rs.getString("inquiry_title")); 
				inquiryList.setResponserTF(rs.getString("responserTF"));
				/*
				if (book.getAvailability() != null) {
                    if (book.getAvailability().equals("1")) {
                        book.setAvailability("대출가능");
                    } else {
                        book.setAvailability("대출불가");
                    }
                } else {
                    book.setAvailability("알수없음");
                }*/
				
                return inquiryList;
			}
		}, userId);
	}
	
}
