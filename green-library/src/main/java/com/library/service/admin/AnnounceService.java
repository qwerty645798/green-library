package com.library.service.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

 public interface AnnounceService {

    // 모든 공지 조회
     List<AnnouncementDTO> allAnnounceManage();

//    전체에서 조회
    List<AnnouncementDTO> findAnnounceByTotal(String total);

    // 제목으로 조회
     List<AnnouncementDTO> findAnnounceByTitle(String title);

    // 내용으로 조회
     List<AnnouncementDTO> findAnnounceByContents(String contents);

    // 공지 생성
//     void createAnnounce(AnnouncementDTO announcement) throws IOException;
     void createAnnounceWithoutFile(String announceTitle, String adminId,String announceContent);
    void createAnnounce(String announceTitle, String adminId, String announceContent, MultipartFile file);
    // 공지 수정
    void updateAnnounceWithoutFile(String announceTitle, String adminId, String announceContent, String aNull);
     void updateAnnounce(String announceTitle, String adminId, String announceContent, MultipartFile file);

    // 공지 삭제
     void deleteAnnounce(List<String> ids);

    // 특정 도서 상세 조회
     AnnouncementDTO getAnnounceById(int id);

    // 이전 도서 제목 조회
     String previousAnnounce(int id);

    // 다음 도서 제목 조회
     String nextAnnounce(int id);
 }
