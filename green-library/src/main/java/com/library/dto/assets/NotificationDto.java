package com.library.dto.assets;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDto {
	
	private int announcementId;
	private String writerId;
	private String announcementTitle;
	private Date writeDate;
	private String contents;
	
	@NotBlank(message = "조회수가 입력되지 않았습니다.")
	private int viewCount;
	
}
