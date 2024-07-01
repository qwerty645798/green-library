package com.library.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.admin._normal.AdminDTO;
import com.library.repository.admin.AdminRepository;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    // 모든 관리자 목록 조회
    @Override
    public List<AdminDTO> allAdminManage() {
        return adminRepository.allAdminManage();
    }
    
    @Override
    public AdminDTO findAdminById(String adminId) {
        return adminRepository.getMyInfo(adminId);
    }

}
