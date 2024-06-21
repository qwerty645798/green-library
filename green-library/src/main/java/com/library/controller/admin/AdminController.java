package com.library.controller.admin;

import com.library.dto.admin._normal.AdminDTO;
import com.library.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    @ResponseBody
    public AdminDTO loginAdmin(@RequestParam String adminId, @RequestParam String adminPass) {
        return adminService.loginAdmin(adminId, adminPass);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<AdminDTO> allAdminManage() {
        return adminService.allAdminManage();
    }

    @GetMapping("/{adminId}")
    @ResponseBody
    public AdminDTO findAdminById(@PathVariable String adminId) {
        return adminService.findAdminById(adminId);
    }
}
