package com.library.service.admin;

import com.library.dto.admin._normal.UserDTO;
import com.library.dto.admin._normal.BookDTO;
import com.library.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 모든 사용자 목록 조회
    public List<UserDTO> getAllUsers() {
//        return userRepository.getAllUsers();
        return null;
    }

    // 사용자 상세 정보 조회
    public UserDTO getUserById(String userId) {
//        return userRepository.getUserById(userId);
        return null;
    }


    // 사용자 삭제
    @Transactional
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }

    // 사용자 대출 현황 조회
    public List<BookDTO> getUserLoanHistory(String userId) {
//        return userRepository.getUserLoanHistory(userId);
        return null;
    }

    // 사용자 제한 해제
    @Transactional
    public void releaseUserRestriction(String userId) {
//        userRepository.releaseUserRestriction(userId);
    }
}
