package com.library.service.admin;

import com.library.dto.admin._normal.AdminDTO;
import com.library.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminService {
    // 관리자 로그인 확인
    public AdminDTO loginAdmin(String adminId, String adminPass);
    // 모든 관리자 목록 조회
    public List<AdminDTO> allAdminManage();
    public AdminDTO findAdminById(String adminId);
}