package com.library.repository.admin;

import com.library.dto.admin._normal.AnnouncementDTO;

import java.util.List;

public interface AnnouncementRepository {

    // 모든 공지사항 목록 조회
    List<AnnouncementDTO> allAnnounceManage();

    // 제목으로 공지사항 검색
    List<AnnouncementDTO> findAnnounceByTitle(String title);

    // 내용으로 공지사항 검색
    List<AnnouncementDTO> findAnnounceByContents(String contents);

    // 공지사항 생성
    void createAnnounce(AnnouncementDTO announcement);

    // 공지사항 수정
    void updateAnnounce(AnnouncementDTO announcement);

    // 공지사항 삭제
    void deleteAnnounce(int announceId);

    // 특정 공지사항 조회
    AnnouncementDTO getAnnounceById(int announceId);

    // 이전 공지 제목 조회
    String previousAnnounce(int announceId);

    // 다음 공지 제목 조회
    String nextAnnounce(int announceId);

}
