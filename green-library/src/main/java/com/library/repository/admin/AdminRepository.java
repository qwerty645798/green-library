package com.library.repository.admin;

import com.library.dto.admin._normal.AdminDTO;
import java.util.List;

public interface AdminRepository {

    // 모든 관리자 목록 조회
    List<AdminDTO> allAdminManage();

    // 내 계정 정보 조회
    AdminDTO getMyInfo(String adminId);

    // 관리자 로그인 확인
    AdminDTO loginAdmin(String adminId, String adminPass);
}
