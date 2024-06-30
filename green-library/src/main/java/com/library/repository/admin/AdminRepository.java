package com.library.repository.admin;

import java.util.List;

import com.library.dto.admin._normal.AdminDTO;
import com.library.dto.admin.adminLogin.AdminLoginDTO;

public interface AdminRepository {

    // 모든 관리자 목록 조회
    List<AdminDTO> allAdminManage();

    // 내 계정 정보 조회
    AdminDTO getMyInfo(String adminId);

    // 관리자 로그인 확인
    AdminLoginDTO loginAdmin(String adminId);
}
