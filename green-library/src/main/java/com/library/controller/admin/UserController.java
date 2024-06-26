package com.library.controller.admin;

import com.library.dto.admin._normal.UserDTO;
import com.library.dto.admin.userManagement.UserDetailDTO;
import com.library.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller("AdminUserController")
@RequestMapping("/User")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //    접속시
    @GetMapping()
    public String showAllUsers(Model model) {
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/adminManagements/user/userManage";
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> searchUsers(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

        List<UserDTO> users;

        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            users = userService.getAllUsers();
        } else {
            switch (searchType) {
                case "name":
                    users = userService.findUserByName(searchKeyword);
                    break;
                case "userId":
                    users = userService.findUserById(searchKeyword);
                    break;
                default:
                    users = userService.findUserByTotal(searchKeyword);
                    break;
            }
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping("/details")
    public ResponseEntity<UserDetailDTO> getUserDetails(@RequestParam("userId") String userId) {
        UserDetailDTO userDetails = userService.getUserDetail(userId);
        return ResponseEntity.ok(userDetails);
    }
}
