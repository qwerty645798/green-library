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
		String sql = "SELECT announce_title, write_date, view_count, fileName, contents "
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
				/*
				if (announce.getFileName() == null) {
                    announce.setFileName("첨부 파일이 없습니다");
                } // 이거는 필요없으면 그냥 지우는걸로
				*/
				return announce;
			}
		}, announcementId); //요게 bookID 기준으로 데이터 셋하는거?
		
	}
}
