package com.library.controller.admin;

import com.library.dto.admin._normal.InquiryDTO;
import com.library.service.admin.InquiryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Inquiry")
public class InquiryController {

    private InquiryService inquiryService;

    @Autowired
    public void setInquiryService(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    //    초기 출력
    @GetMapping()
    public String inquiry(Model model) {
        List<InquiryDTO> inquiry = inquiryService.allInquiryManage(false, false);
        model.addAttribute("inquiry", inquiry);
        return "admin/adminManagements/inquiry/inquiryManage";
    }

    //    검색
    @GetMapping("/search")
    public ResponseEntity<List<InquiryDTO>> searchInquiries(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
            @RequestParam(value = "showAnswered", required = false, defaultValue = "false") boolean showAnswered,
            @RequestParam(value = "showOnlyAnswered", required = false, defaultValue = "false") boolean showOnlyAnswered) {

        List<InquiryDTO> inquiries;
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            inquiries = inquiryService.allInquiryManage(showAnswered, showOnlyAnswered);
        } else {
            inquiries = inquiryService.searchInquiries(searchType, searchKeyword, showAnswered, showOnlyAnswered);
        }
        return ResponseEntity.ok(inquiries);
    }

    //    삭제
    @PostMapping("/deleteInquiry")
    public ResponseEntity<String> deleteInquiry(@RequestBody List<String> inquiryIds) {
        inquiryService.deleteInquiry(inquiryIds);
        return ResponseEntity.ok("삭제 성공");
    }

    // POST 요청 처리
    @PostMapping("/createBtnClick/{id}")
    @ResponseBody // JSON 형태의 응답을 반환할 경우 사용
    public String createBtnClick(@PathVariable int id) {
        return "success";
    }

    // 작성페이지 이동
    @GetMapping("/WriteInquiry")
    public String writeInquiry(@RequestParam("inquiryId") int inquiryId, Model model) {
        InquiryDTO inquiry = inquiryService.getInquiryById(inquiryId);
        model.addAttribute("inquiry", inquiry);
        return "admin/adminManagements/inquiry/inquiryWrite";
    }


    // 질의 답변 등록 처리
    @PostMapping("/UploadInquiry")
    @ResponseBody
    public String uploadInquiry(@RequestParam("inquiryId") int inquiryId,
                                @RequestParam("responseContents") String responseContents,
                                HttpSession session) {
        try {
//            String adminId = (String) session.getAttribute("adminId");
            String adminId = "admin0";

            inquiryService.createInquiry(inquiryId, responseContents, adminId);
            return "등록 성공";
        } catch (Exception e) {
            e.printStackTrace();
            return "오류 발생: " + e.getMessage();
        }
    }

    // POST 요청 처리
    @PostMapping("/viewBtnClick/{id}")
    @ResponseBody // JSON 형태의 응답을 반환할 경우 사용
    public String viewBtnClick(@PathVariable int id) {
        return "success";
    }

    // 확인페이지 이동
    @GetMapping("/DetailInquiry")
    public String detailInquiry(@RequestParam("inquiryId") int inquiryId, Model model) {
        InquiryDTO inquiry = inquiryService.getInquiryById(inquiryId);
        model.addAttribute("inquiry", inquiry);
        return "admin/adminManagements/inquiry/inquiryDetail";
    }

        @GetMapping("/prevInquiry")
        public ResponseEntity<InquiryDTO> getPreviousInquiry(@RequestParam("inquiryId") int inquiryId) {
            try {
                InquiryDTO prevInquiry = inquiryService.previousInquiry(inquiryId);
                return new ResponseEntity<>(prevInquiry, HttpStatus.OK);

        }catch (Exception e){
            return null;
        }
        }

        @GetMapping("/nextInquiry")
        public ResponseEntity<InquiryDTO> getNextInquiry(@RequestParam("inquiryId") int inquiryId) {
        try {
            InquiryDTO nextInquiry = inquiryService.nextInquiry(inquiryId);
            return new ResponseEntity<>(nextInquiry, HttpStatus.OK);
        }catch (Exception e){
            return null;
        }
        }
    }
