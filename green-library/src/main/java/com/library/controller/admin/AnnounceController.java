package com.library.controller.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.service.admin.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping("/writingAnnounce")
    public String writingAnnouncement(Model model) {
        return "admin/adminManagements/announcement/announceWrite";
    }

    @GetMapping("/detailAnnouncement")
    public String detailAnnouncement(Model model) {
        return "admin/adminManagements/announcement/announceDetail";
    }
}

