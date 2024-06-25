package com.library.dto.assets;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDetailDto {
	private String announceTitle;
	private Date writeDate;
	private int viewCount;
	private String fileName;
	private String contents;
	
	private String writerId;
}
