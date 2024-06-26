package com.library.controller.admin;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import com.library.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller("AdminUserController")
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    //    접속시
    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/adminManagements/user/userManage";
    }

    @GetMapping("/User/search")
    public String searchUsers(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
            Model model) {

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
                    users = userService.getAllUsers();
                    break;
            }
        }

        model.addAttribute("users", users);
        return "admin/adminManagements/user/userManage";
    }

//    이후로 하나씩 수정하기
    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        UserDTO user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/adminManagements/user/userDetail";
    }



    @GetMapping("/{userId}/loans")
    public String loanUserById(@PathVariable int userId, Model model) {
        List<RentDTO> loans = userService.loanUserById(userId);
        model.addAttribute("loans", loans);
        return "admin/adminManagements/user/userLoans";
    }

    @GetMapping("/{userId}/suspensions")
    public String suspensionUserById(@PathVariable int userId, Model model) {
        List<SuspensionDTO> suspensions = userService.suspensionUserById(userId);
        model.addAttribute("suspensions", suspensions);
        return "admin/adminManagements/user/userSuspensions";
    }

    @PostMapping("/suspension/create")
    public String createSuspension(@ModelAttribute SuspensionDTO suspension) {
        userService.createSuspension(suspension);
        return "redirect:/admin/users/{userId}/suspensions";
    }

    @DeleteMapping("/{userId}/delete")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/users/all";
    }

    @PostMapping("/{userId}/suspension/release")
    public String releaseUserSuspension(@PathVariable int userId) {
        userService.releaseUserSuspension(userId);
        return "redirect:/admin/users/{userId}/suspensions";
    }

}
