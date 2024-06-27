package com.library.controller.admin;

import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import com.library.dto.admin.userManagement.UserDetailDTO;
import com.library.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            users = switch (searchType) {
                case "name" -> userService.findUserByName(searchKeyword);
                case "userId" -> userService.findUserById(searchKeyword);
                default -> userService.findUserByTotal(searchKeyword); //제목 + 저자 + 출판
            };
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping("/details")
    public ResponseEntity<UserDetailDTO> getUserDetails(@RequestParam("userId") String userId) {
        UserDetailDTO userDetails = userService.getUserDetail(userId);
        return ResponseEntity.ok(userDetails);
    }

    @PostMapping("/deleteUsers")
    public ResponseEntity<String> deleteUsers(@RequestBody List<String> userIds) {
            userService.deleteUsers(userIds);
            return ResponseEntity.ok("사용자 삭제가 성공적으로 수행되었습니다.");
    }

    // Endpoint to release ban for a user
    @GetMapping("/releaseBan")
    @PostMapping("/releaseBan")
    public ResponseEntity<String> releaseBan(@RequestParam("userId") String userId) {
            userService.releaseSuspension(userId);
            return ResponseEntity.ok("사용자의 제한이 성공적으로 해제되었습니다.");
    }
}
