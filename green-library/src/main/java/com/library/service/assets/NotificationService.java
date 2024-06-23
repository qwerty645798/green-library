package com.library.service.assets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.assets.NotificationDto;
import com.library.repository.assets.NotificationRepository;

@Service
public class NotificationService {

	@Autowired 
	private NotificationRepository notificationRepository;
	
	public List<NotificationDto> findAnnounce(String inputCategory, String inputText) {
		return notificationRepository.findNotification(inputCategory, inputText);
	}
	
	public List<NotificationDto> findAnnounce2() {
		return notificationRepository.findNotification2();
	}
	
	
}
