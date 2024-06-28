package com.library.controller.admin;

import com.library.dto.admin._normal.InquiryDTO;
import com.library.service.admin.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Inquiry")
public class InquiryController {

    private InquiryService inquiryService;

    @Autowired
    public void setInquiryService(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping()
    public String inquiry(Model model) {
        List<InquiryDTO> inquiry = inquiryService.allInquiryManage();
        model.addAttribute("inquiry", inquiry);
        return "admin/adminManagements/inquiry/inquiryManage";
    }

    @GetMapping("/search")
    public ResponseEntity<List<InquiryDTO>> searchInquiries(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

        List<InquiryDTO> inquiries;
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            inquiries = inquiryService.allInquiryManage();
        } else {
            inquiries = switch (searchType) {
                case "title" -> inquiryService.findInquiryByTitle(searchKeyword);
                case "contents" -> inquiryService.findInquiryByContents(searchKeyword);
                default -> inquiryService.findInquiryByTotal(searchKeyword);
            };
        }
        return ResponseEntity.ok(inquiries);
    }

    @PostMapping("/deleteInquiry")
    public String deleteInquiry(@RequestParam("id") long id) {
        return null;
    }



    @GetMapping("/WritingInquiry")
    public String writingInquiry(Model model) {
        return "admin/adminManagements/inquiry/inquiryWrite";
    }

    @GetMapping("/DetailInquiry")
    public String detailInquiry(Model model) {
        return "admin/adminManagements/inquiry/inquiryDetail";
    }
}
