package com.library.service.admin;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import com.library.dto.admin.userManagement.UserDetailDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    List<UserDTO> findUserById(String id);

    List<UserDTO> findUserByName(String name);

    List<UserDTO> findUserByTotal(String total);

    UserDetailDTO getUserDetail(String id);

    UserDTO getUserById(String id);

    List<RentDTO> loanUserById(String userId);

    List<SuspensionDTO> suspensionUserById(String userId);

    int createSuspension(SuspensionDTO suspension);

    void deleteUsers(List<String> userIds);

    void releaseSuspension(String userId);
}
