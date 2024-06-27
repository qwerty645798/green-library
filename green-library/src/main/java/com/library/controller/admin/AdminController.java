package com.library.controller.admin;

import com.library.dto.admin._normal.AdminDTO;
import com.library.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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


//    내 계정 정보
    @GetMapping("/myInfo")
    public String adminInfo(Model model){
        AdminDTO my = adminService.findAdminById("admin0");
        model.addAttribute("admin", my);
        return "admin/adminInfo/adminInfo";
    }


    //    관리자 정보 모음
    @GetMapping("/adminInfo")
    public String adminList(Model model) {
        AdminDTO my = adminService.findAdminById("admin0");
        model.addAttribute("my", my);

        List<AdminDTO> admins = adminService.allAdminManage();
        model.addAttribute("admins", admins);
        return "admin/adminInfo/adminInfo";
    }

}
