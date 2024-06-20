package com.library.service.assets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.assets.NotificationDetailDto;
import com.library.repository.assets.NotificationDetailrepository;

@Service
public class NotificationDetailService {

	@Autowired
	private NotificationDetailrepository notificationDetailrepository;
	
	public NotificationDetailDto getAnnounceDetail(String announcementId) {
		return notificationDetailrepository.findByannouncementId(announcementId);
	}
}
