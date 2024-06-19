package com.library.service.admin;

import com.library.dto.admin._normal.AdminDTO;
import com.library.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // 관리자 로그인 확인
    public AdminDTO loginAdmin(String adminId, String adminPass) {
        return adminRepository.loginAdmin(adminId, adminPass);
    }

    // 모든 관리자 목록 조회
    public List<AdminDTO> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

}
