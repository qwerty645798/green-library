package com.library.controller.admin;

import com.library.dto.admin._normal.AdminDTO;
import com.library.service.admin.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller("AdminController")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String home() {
        return "admin/adminLogin/adminLogin";
    }

    //login -> main index
    @GetMapping("/adminIndex")
    public String adminIndex(Model model) {
        return "admin/adminIndex/adminIndex";
    }

    //    내 정보 & 관리자 정보 모음
    @GetMapping("/adminInfo")
    public String adminList(Model model, HttpServletRequest request) {
        AdminDTO my = adminService.findAdminById("admin0");
        model.addAttribute("my", my);

        // Fetching all admin information
        List<AdminDTO> admins = adminService.allAdminManage();
        model.addAttribute("admins", admins);

        // Fetching request parameters and user agent details
        String ipAddress = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String os = System.getProperty("os.name");
        String browser = "Unknown Browser";

        if (userAgent != null) {
            if (userAgent.contains("Chrome")) {
                browser = "Chrome";
            } else if (userAgent.contains("Firefox")) {
                browser = "Firefox";
            } else if (userAgent.contains("Safari") && !userAgent.contains("Chrome")) {
                browser = "Safari";
            } else if (userAgent.contains("Opera") || userAgent.contains("OPR")) {
                browser = "Opera";
            } else if (userAgent.contains("Edge")) {
                browser = "Edge";
            } else if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                browser = "Internet Explorer";
            }
        }
        model.addAttribute("ipAddress", ipAddress);
        model.addAttribute("os", os);
        model.addAttribute("browser", browser);

        return "admin/adminInfo/adminInfo";
    }


}
