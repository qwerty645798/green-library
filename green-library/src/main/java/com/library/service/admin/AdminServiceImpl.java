package com.library.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.dto.admin._normal.AdminDTO;
import com.library.dto.admin.adminLogin.AdminLoginDTO;
import com.library.repository.admin.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    // 관리자 로그인 확인
    @Override
	public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
    	try{
    		AdminLoginDTO adminDTO = adminRepository.loginAdmin(adminId);
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			return User
					.withUsername(adminDTO.getAdminID())
					.password(adminDTO.getAdminPass())
					.authorities(authorities)
					.build();
		} catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Login failed - User not found with adminId: " + adminId, e);
	    }
	}

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
