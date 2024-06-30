package com.library.service.admin;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.library.dto.admin._normal.AdminDTO;

public interface AdminService/* extends UserDetailsService */{

	// 모든 관리자 목록 조회
    List<AdminDTO> allAdminManage();

    AdminDTO findAdminById(String adminId);

}
