package com.library.service.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.repository.admin.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnouncementRepository announcementRepository;


    // 모든 공지 조회
    @Override
    public List<AnnouncementDTO> allAnnounceManage() {
        return announcementRepository.allAnnounceManage();
    }

    //    select 제한 두기
//    @Override
//    public int getTotalAnnouncementsCount() {
//        return (int) announcementRepository.count();
//    }
//
//    @Override
//    public List<AnnouncementDTO> getAnnouncements(int limit) {
//        return announcementRepository.findAll()
//                .stream()
//                .limit(limit)
//                .collect(Collectors.toList());
//    }

    // 제목으로 조회
    @Override
    public List<AnnouncementDTO> findAnnounceByTitle(String title) {
        return announcementRepository.findAnnounceByTitle(title);
    }

    // 내용으로 조회
    @Override
    public List<AnnouncementDTO> findAnnounceByContents(String contents) {
        return announcementRepository.findAnnounceByContents(contents);
    }

    // 공지 생성
    @Override
    public void createAnnounce(AnnouncementDTO announcement) {
        announcementRepository.createAnnounce(announcement);
    }

    // 공지 수정
    @Override
    public void updateAnnounce(AnnouncementDTO announcement) {
        announcementRepository.updateAnnounce(announcement);
    }

    // 공지 삭제
    @Override
    public void deleteAnnounce(int id) {
        announcementRepository.deleteAnnounce(id);
    }

    // 특정 도서 상세 조회
    @Override
    public AnnouncementDTO getAnnounceById(int id) {
        return announcementRepository.getAnnounceById(id);
    }

    // 이전 도서 제목 조회
    @Override
    public String previousAnnounce(int id) {
        return announcementRepository.previousAnnounce(id);
    }

    // 다음 도서 제목 조회
    @Override
    public String nextAnnounce(int id) {
        return announcementRepository.nextAnnounce(id);
    }
}
