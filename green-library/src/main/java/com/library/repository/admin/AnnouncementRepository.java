package com.library.repository.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnnouncementRepository {

    // 모든 공지사항 목록 조회
    List<AnnouncementDTO> allAnnounceManage();

    //전체에서 공지사항 검색
    List<AnnouncementDTO> findAnnounceByTotal(String total);

    // 제목으로 공지사항 검색
    List<AnnouncementDTO> findAnnounceByTitle(String title);

    // 내용으로 공지사항 검색
    List<AnnouncementDTO> findAnnounceByContents(String contents);

    // 공지사항 생성
    void createAnnounce(AnnouncementDTO announcement);
    void createAnnounceWithoutFile(String announceTitle, String adminId, String announceContent);
    void createAnnounce(String announceTitle, String adminId, String announceContent, MultipartFile file);
    // 공지사항 수정

    void updateAnnounce(String announceTitle, String adminId, String announceContent, MultipartFile file);
    void updateAnnounceWithoutFile(String announceTitle, String adminId, String announceContent, String aNull);

    // 공지사항 삭제
    void deleteAnnounce(List<String> announceId);

    // 특정 공지사항 조회
    AnnouncementDTO getAnnounceById(int announceId);

    // 이전 공지 제목 조회
    String previousAnnounce(int announceId);

    // 다음 공지 제목 조회

    String nextAnnounce(int announceId);
}
