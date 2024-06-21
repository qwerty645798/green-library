package com.library.repository.assets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.assets.NotificationDto;

@Repository
public class NotificationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<NotificationDto> findNotification(String inputCategory, String inputText) {
		String sql = "SELECT announcement_id, writer_id, announce_title, write_date, contents "
		           + "FROM announcements ";
		           
		if ("제목과 본문".equals(inputCategory)) {
	        sql += " WHERE announce_title LIKE '%" + inputText + "%' " 
	               +"OR contents LIKE '%" + inputText + "%' ";
	    } else if ("제목".equals(inputCategory)) {
	        sql += "WHERE announce_title LIKE '%" + inputText + "%' ";
	    } else if ("본문".equals(inputCategory)) {
	        sql += "WHERE contents LIKE '%" + inputText + "%' ";
	    }
		           
		sql += "ORDER BY announcement_id desc";
		
        return jdbcTemplate.query(sql, new RowMapper<NotificationDto>() {
            @Override
            public NotificationDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                NotificationDto announce = new NotificationDto();
                announce.setAnnouncementId(rs.getInt("announcement_id"));
                announce.setWriterId(rs.getString("writer_id"));
                announce.setAnnouncementTitle(rs.getString("announce_title"));
                announce.setWriteDate(rs.getDate("write_date"));
                announce.setContents(rs.getString("contents"));
                return announce;
            }
        });
        
	}
}
