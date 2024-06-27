package com.library.controller.admin;

import com.library.dto.admin._normal.AnnouncementDTO;
import com.library.service.admin.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnnounceController {

    private AnnounceService announceService;

    @Autowired
    public void setAnnounceService(AnnounceService announceService) {
        this.announceService = announceService;
    }

//    접속시 리스트 보여주기
    @GetMapping("/announcement")
    public String announcement(Model model) {
        List<AnnouncementDTO> announcements = announceService.allAnnounceManage();
        model.addAttribute("announcements", announcements);
        return "admin/adminManagements/announcement/announManage";
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
