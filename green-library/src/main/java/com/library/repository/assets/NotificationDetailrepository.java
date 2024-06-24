package com.library.repository.assets;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.assets.NotificationDetailDto;

@Repository
public class NotificationDetailrepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public NotificationDetailDto findByannouncementId(String announcementId) {
		String sql = "SELECT announce_title, write_date, view_count, fileName, contents, writer_id "
                + "FROM announcements "
                + "WHERE announcement_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<NotificationDetailDto>() {
			@Override
			public NotificationDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				NotificationDetailDto announce = new NotificationDetailDto();
				announce.setAnnounceTitle(rs.getString("announce_title"));
				announce.setWriteDate(rs.getDate("write_date"));
				announce.setViewCount(rs.getInt("view_count"));
				announce.setFileName(rs.getString("fileName"));
				announce.setContents(rs.getString("contents"));
				announce.setWriterId(rs.getString("writer_id"));
				
				return announce;
			}
		}, announcementId); 
	}
	
	public void incrementViewCount(int announcementId) {
		String sql = "Update announcements "
				+ "SET view_count = view_count + 1 "
				+ "WHERE announcement_id = ?";
		jdbcTemplate.update(sql, announcementId);
	}
}
