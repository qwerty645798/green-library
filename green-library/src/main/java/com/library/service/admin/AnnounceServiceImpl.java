package com.library.service.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.repository.admin.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnouncementRepository announcementRepository;
    private static final String UPLOAD_DIR = "/static/documents";


    // 모든 공지 조회
    @Override
    public List<AnnouncementDTO> allAnnounceManage() {
        return announcementRepository.allAnnounceManage();
    }

//    전체에서 조회
    @Override
    public List<AnnouncementDTO> findAnnounceByTotal(String total) {
        return announcementRepository.findAnnounceByTotal(total);
    }

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
    public void createAnnounceWithoutFile(String announceTitle, String adminId,String announceContent){
        announcementRepository.createAnnounceWithoutFile(announceTitle, adminId,announceContent);
    }

    @Override
    public void createAnnounce(String announceTitle, String adminId, String announceContent, MultipartFile file) {
        announcementRepository.createAnnounce(announceTitle, adminId, announceContent, file);
    }

//    @Override
//    public void createAnnounce(AnnouncementDTO announcement) throws IOException {
//        announcementRepository.createAnnounce(announcement);
//        try {
//            String fileName = saveFile(announcement.getFile());
//            announcement.setFileName(fileName);
//
//            announcementRepository.createAnnounce(announcement);
//        } catch (IOException e) {
//            throw new IOException("파일 업로드 중 오류가 발생했습니다.");
//        }
//    }

//    private String saveFile(MultipartFile file) throws IOException {
//        if (file == null || file.isEmpty()) {
//            return null;
//        }
//
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        byte[] bytes = file.getBytes();
//        Path path = Paths.get(UPLOAD_DIR + fileName);
//        Files.write(path, bytes);
//
//        return fileName;
//    }
    // 공지 수정
@Override
public void updateAnnounceWithoutFile(String announceTitle, String adminId, String announceContent, String aNull) {
announcementRepository.updateAnnounceWithoutFile(announceTitle, adminId, announceContent, aNull);
}

    @Override
    public void updateAnnounce(String announceTitle, String adminId, String announceContent, MultipartFile file) {
        announcementRepository.updateAnnounce(announceTitle, adminId, announceContent, file);
    }

    // 공지 삭제
    @Override
    public void deleteAnnounce(List<String> id) {
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
