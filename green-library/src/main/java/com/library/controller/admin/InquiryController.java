package com.library.controller.admin;

import com.library.dto.admin._normal.InquiryDTO;
import com.library.service.admin.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
        List<InquiryDTO>inquiry = inquiryService.allInquiryManage();
        model.addAttribute("inquiry", inquiry);
        return "admin/adminManagements/inquiry/inquiryManage";
    }

    @GetMapping("/searchInquiries")
    public String searchInquiries(@RequestParam(value = "searchType", required = false) String searchType,
                                  @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
                                  @RequestParam(value = "perPage", required = false) Optional<Integer> perPage,
                                  Model model) {
        int inquiriesPerPage = perPage.orElse(10); // Default to 10 if not specified

        List<InquiryDTO> inquiries;
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            inquiries = inquiryService.allInquiryManage();
        } else {
            switch (searchType) {
                case "title":
                    inquiries = inquiryService.findInquiryByTitle(searchKeyword);
                    break;
                case "contents":
                    inquiries = inquiryService.findInquiryByContents(searchKeyword);
                    break;
                default:
                    inquiries = inquiryService.allInquiryManage();
                    break;
            }
        }

//        int totalInquiries = inquiryService.getTotalInquiriesCount();

        model.addAttribute("inquiries", inquiries);
//        model.addAttribute("totalInquiries", totalInquiries);
        model.addAttribute("perPage", inquiriesPerPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchKeyword", searchKeyword);

        return "admin/adminManagements/inquiry/inquiryManage";
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
