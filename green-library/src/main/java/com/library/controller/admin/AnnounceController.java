package com.library.controller.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.service.admin.AnnounceService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequestMapping("/Announcement")
@Controller
public class AnnounceController {

    private AnnounceService announceService;

    @Autowired
    public void setAnnounceService(AnnounceService announceService) {
        this.announceService = announceService;
    }


    @GetMapping()
    public String announce(Model model) {
        List<AnnouncementDTO> announce = announceService.allAnnounceManage();
        model.addAttribute("announce", announce);
        return "admin/adminManagements/announcement/announManage";
    }

    //    검색
    @GetMapping("/search")
    public ResponseEntity<List<AnnouncementDTO>> searchAnnounce(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

        List<AnnouncementDTO> announce = List.of();
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            announce = announceService.allAnnounceManage();
        } else if (searchType.equals("all")) {
            announce = announceService.findAnnounceByTotal(searchKeyword);
        } else if (searchType.equals("title")) {
            announce = announceService.findAnnounceByTitle(searchKeyword);
        } else if (searchType.equals("contents")) {
            announce = announceService.findAnnounceByContents(searchKeyword);
        }
        return ResponseEntity.ok(announce);
    }

    //    작성
    @GetMapping("/writingAnnounce")
    public String writingAnnouncement(Model model) {
        return "admin/adminManagements/announcement/announceWrite";
    }

    // 업로드
    @PostMapping("/uploadAnnounce")
    public String uploadAnnounce(@RequestParam("announceTitle") String announceTitle,
                                 @RequestParam("announceContent") String announceContent,
                                 @RequestParam(value = "file", required = false) MultipartFile file,
                                 HttpServletRequest request) {
        String adminId = request.getParameter("adminId");
        if (file == null || file.isEmpty())
            announceService.createAnnounceWithoutFile(announceTitle, adminId, announceContent);
        else
            announceService.createAnnounce(announceTitle, adminId, announceContent, file);
        return "redirect:/Announcement";
    }

    //    수정
    // POST 요청 처리
    @PostMapping("/updateBtnClick/{id}")
    @ResponseBody // JSON 형태의 응답
    public String updateBtnClick(@PathVariable int id) {
        return "success";
    }

    //페이지 이동
    @GetMapping("/updateAnnounce")
    public String writeAnnounce(@RequestParam("announceId") int announceId, Model model) {
        AnnouncementDTO announce = announceService.getAnnounceById(announceId);
        model.addAttribute("announce", announce);
        return "admin/adminManagements/announcement/announceWrite";
    }

    // 수정 페이지
    @GetMapping("/getAnnounceById/{announceId}")
    public ResponseEntity<AnnouncementDTO> getAnnounceById(@PathVariable int announceId) {
        AnnouncementDTO announce = announceService.getAnnounceById(announceId);
        if (announce == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(announce);
    }

    //    수정 등록
    @PostMapping("/updateAnnounce")
    public String uploadComplete(@RequestParam("announceTitle") String announceTitle,
                                 @RequestParam("announceContent") String announceContent,
                                 @RequestParam(value = "file", required = false) MultipartFile file,
                                 HttpServletRequest request) {
        String adminId = request.getParameter("adminId");
        if (file == null || file.isEmpty()) {
            announceService.updateAnnounceWithoutFile(announceTitle, adminId, announceContent, "null");
        } else {
            announceService.updateAnnounce(announceTitle, adminId, announceContent, file);
        }
        return "redirect:/Announcement";
    }


    //    삭제
    @PostMapping("/deleteAnnounce")
    public ResponseEntity<String> deleteAnnounce(@RequestBody List<String> AnnounceIds) {
        announceService.deleteAnnounce(AnnounceIds);
        return ResponseEntity.ok("삭제 성공");
    }
}

