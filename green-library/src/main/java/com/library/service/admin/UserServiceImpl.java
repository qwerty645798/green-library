package com.library.service.admin;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import com.library.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminUserService")
public class UserServiceImpl implements UserService {

    @Qualifier("AdminUserRepository")
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.allUserManage();
    }

    @Override
    public List<UserDTO> findUserById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<UserDTO> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public UserDTO getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<RentDTO> loanUserById(int userId) {
        return userRepository.loanUserById(userId);
    }

    @Override
    public List<SuspensionDTO> suspensionUserById(int userId) {
        return userRepository.suspensionUserById(userId);
    }

    @Override
    public int createSuspension(SuspensionDTO suspension) {
        return userRepository.createSuspension(suspension);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteUsers(userId);
    }

    @Override
    public void releaseUserSuspension(int userId) {
        userRepository.releaseSuspension(userId);
    }
}
