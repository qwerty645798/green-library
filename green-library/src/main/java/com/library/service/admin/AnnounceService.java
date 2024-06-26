package com.library.service.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.repository.admin.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnnounceService {

    // 모든 공지 조회
    public List<AnnouncementDTO> allAnnounceManage();

//    select 제한 두기
//    int getTotalAnnouncementsCount();
//    List<AnnouncementDTO> getAnnouncements(int limit);

    // 제목으로 조회
    public List<AnnouncementDTO> findAnnounceByTitle(String title);

    // 내용으로 조회
    public List<AnnouncementDTO> findAnnounceByContents(String contents);

    // 공지 생성
    public void createAnnounce(AnnouncementDTO announcement);

    // 공지 수정
    public void updateAnnounce(AnnouncementDTO announcement);

    // 공지 삭제
    public void deleteAnnounce(int id);

    // 특정 도서 상세 조회
    public AnnouncementDTO getAnnounceById(int id);

    // 이전 도서 제목 조회
    public String previousAnnounce(int id);

    // 다음 도서 제목 조회
    public String nextAnnounce(int id);
}
