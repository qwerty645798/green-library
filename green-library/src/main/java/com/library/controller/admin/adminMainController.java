package com.library.controller.admin;

import org.springframework.ui.Model;
import com.library.dto.admin._normal.UserDTO;
import com.library.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Controller
public class adminMainController {
    String url = "jdbc:oracle:thin:@//localhost:1521/XE";
    String username = "springboot";
    String password = "1234";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

    @Autowired
    private UserService userService;


    //    login, home
    @GetMapping("/admin")
    public String home() {
        return "admin/adminLogin/adminLogin";
    }

    //login -> main index
    @GetMapping("/adminIndex")
    public String adminIndex(Model model) {
        return "admin/adminIndex/adminIndex";
    }

    //    managers information
    @GetMapping("/adminInfo")
    public String adminInfo(Model model) {
        return "admin/adminInfo/adminInfo";
    }

    //announcement
    @GetMapping("/announcement")
    public String announcement(Model model) {
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

    //    inquiry

    @GetMapping("/Inquiry")
    public String inquiry(Model model) {
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
//    book
    @GetMapping("/BuyBook")
    public String buy(Model model) {
        return "admin/adminBook/buyBook/bookBuy";
    }

    @GetMapping("/Book")
    public String book(Model model) {
        return "admin/adminBook/manageBook/bookManage";
    }

    @GetMapping("/WriteBook")
    public String writeBook(Model model) {
        return "admin/adminBook/manageBook/bookWrite";
    }

    @GetMapping("/DetailBook")
    public String detailBook(Model model) {
        return "admin/adminBook/manageBook/bookDetail";
    }
}
