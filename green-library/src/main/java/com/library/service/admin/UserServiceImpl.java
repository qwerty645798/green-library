package com.library.service.admin;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import com.library.dto.admin.userManagement.UserDetailDTO;
import com.library.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminUserService")
public class UserServiceImpl implements UserService {

    @Qualifier("AdminUserRepository")
    private UserRepository userRepository;

    public UserServiceImpl(@Qualifier("AdminUserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    public UserDetailDTO getUserDetail(String userId) {
        UserDetailDTO userDetails = new UserDetailDTO();
        userDetails.setUser(userRepository.getUserById(userId));
        userDetails.setLoans(userRepository.loanUserById(userId));
        userDetails.setSuspensions(userRepository.suspensionUserById(userId));
        return userDetails;
    }

    @Override
    public UserDTO getUserById(String id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<RentDTO> loanUserById(String userId) {
        return userRepository.loanUserById(userId);
    }

    @Override
    public List<SuspensionDTO> suspensionUserById(String userId) {
        return userRepository.suspensionUserById(userId);
    }

    @Override
    public int createSuspension(SuspensionDTO suspension) {
        return userRepository.createSuspension(suspension);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteUsers(userId);
    }
}
