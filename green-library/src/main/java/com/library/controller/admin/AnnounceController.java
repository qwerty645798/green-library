package com.library.controller.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.dto.admin._normal.UserDTO;
import com.library.service.admin.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("Announcement")
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

        List<AnnouncementDTO> announce;

        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            announce = announceService.allAnnounceManage();
        } else {
            announce = switch (searchType) {
                case "title" -> announceService.findAnnounceByTitle(searchKeyword);
                case "contents" -> announceService.findAnnounceByContents(searchKeyword);
                default -> announceService.findAnnounceByTotal(searchKeyword);
            };
        }

        return ResponseEntity.ok(announce);
    }

    @GetMapping("/writingAnnounce")
    public String writingAnnouncement(Model model) {
        return "admin/adminManagements/announcement/announceWrite";
    }

    @GetMapping("/detailAnnouncement")
    public String detailAnnouncement(Model model) {
        return "admin/adminManagements/announcement/announceDetail";
    }
}
