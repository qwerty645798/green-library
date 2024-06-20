package com.library.service.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.repository.admin.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceService {

    @Autowired
    private AnnouncementRepository announcementRepository;

     // 모든 공지 조회
    public List<AnnouncementDTO> allAnnounceManage() {
        return announcementRepository.allAnnounceManage();
    }

     // 제목으로 조회
    public List<AnnouncementDTO> findAnnounceByTitle(String title) {
        return announcementRepository.findAnnounceByTitle(title);
    }
    // 내용으로 조회
    public List<AnnouncementDTO> findAnnounceByContents(String contents) {
        return announcementRepository.findAnnounceByContents(contents);
    }
     // 공지 생성
    public void createAnnounce(AnnouncementDTO announcement) {
        announcementRepository.createAnnounce(announcement);
    }
    // 공지 수정
    public void updateAnnounce(AnnouncementDTO announcement) {
        announcementRepository.updateAnnounce(announcement);
    }
    // 공지 삭제
    public void deleteAnnounce(int id) {
        announcementRepository.deleteAnnounce(id);
    }
    // 특정 도서 상세 조회
    public AnnouncementDTO getAnnounceById(int id){
        return announcementRepository.getAnnounceById(id);
    }
    // 이전 도서 제목 조회
    public String previousAnnounce(int id){
        return announcementRepository.previousAnnounce(id);
    }
    // 다음 도서 제목 조회
    public String nextAnnounce(int id){
        return announcementRepository.nextAnnounce(id);
    }
}
