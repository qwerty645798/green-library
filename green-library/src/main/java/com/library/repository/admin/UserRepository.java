package com.library.repository.admin;


import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;

import java.util.List;


public interface UserRepository {

    // 모든 이용자 목록 조회
    List<UserDTO> allUserManage();

    // 아이디로 사용자 조회
    List<UserDTO> findUserById(String userId);

    // 이름으로 사용자 조회
    List<UserDTO> findUserByName(String userName);

//    전체로 사용자 조회
    List<UserDTO> findUserByTotal(String total);


    // 특정 이용자 조회
    UserDTO getUserById(String userId);

    // 해당 유저의 대출 현황 조회
    List<RentDTO> loanUserById(String userId);

    // 해당 유저의 이용 제한 내역 조회
    List<SuspensionDTO> suspensionUserById(String userId);

    // 서비스 제한 생성
    int createSuspension(SuspensionDTO suspension);

    // 유저 영구 삭제
    void deleteUsers(List<String> userIds);

    // 이용 제한 해제
    void releaseSuspension(String userId);

}
