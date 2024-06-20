package com.library.service.admin;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    List<UserDTO> findUserById(String id);

    List<UserDTO> findUserByName(String name);

    UserDTO getUserById(int id);

    List<RentDTO> loanUserById(int userId);

    List<SuspensionDTO> suspensionUserById(int userId);

    int createSuspension(SuspensionDTO suspension);

    void deleteUser(int userId);

    void releaseUserSuspension(int userId);
}
