package com.library.entity;

import java.util.Date;

public class Announcements {
    private Long announcement_id;
    private String announce_title;
    private String writer_id;
    private Date write_date;
    private String fileName;
    private String contents;
    private Integer view_count = 0;
	public Long getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(Long announcement_id) {
		this.announcement_id = announcement_id;
	}
	public String getAnnounce_title() {
		return announce_title;
	}
	public void setAnnounce_title(String announce_title) {
		this.announce_title = announce_title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getView_count() {
		return view_count;
	}
	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}
}