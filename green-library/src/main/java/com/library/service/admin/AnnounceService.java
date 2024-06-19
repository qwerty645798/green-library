package com.library.service.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.repository.admin.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnnounceService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    // 모든 공지사항 목록 조회
    public List<AnnouncementDTO> getAllAnnouncements() {
        return announcementRepository.getAllAnnouncements();
    }

    public List<AnnouncementDTO> getAnnouncementByTitle(String title) {
        return announcementRepository.searchByTitle(title);
    }

    public List<AnnouncementDTO> getAnnouncementByContents(String contents) {
        return announcementRepository.searchByContents(contents);
    }


    // 공지사항 상세 정보 조회
    public AnnouncementDTO getAnnouncementById(Long announcementId) {
        return announcementRepository.getAnnouncementById(announcementId);
    }

    // 공지사항 등록
    @Transactional
    public void createAnnouncement(AnnouncementDTO announcementDTO) {
        announcementRepository.createAnnouncement(announcementDTO);
    }

    // 공지사항 정보 업데이트
    @Transactional
    public void updateAnnouncement(AnnouncementDTO announcementDTO) {
        announcementRepository.updateAnnouncement(announcementDTO);
    }

    // 공지사항 삭제
    @Transactional
    public void deleteAnnouncement(Long announcementId) {
        announcementRepository.deleteAnnouncement(announcementId);
    }
}
