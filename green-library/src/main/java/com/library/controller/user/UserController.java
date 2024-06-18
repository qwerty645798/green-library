package com.library.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.dto.user.UserDto;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/userFinding")
	public String userFinding() {
		return "user/userFinding";
	}

	@GetMapping("/userUseInformation")
	public String userUseInformation() {
		return "user/userUseInformation";
	}

	@GetMapping("/useInformationBoard")
	public String useInformationBoard() {
		return "user/useInformation/board";
	}

	@GetMapping("/userInquiryDetail")
	public String userInquiryDetail() {
		return "user/userInquiryDetail";
	}

	@GetMapping("/userInquiryCreate")
	public String userInquiryCreate() {
		return "user/userInquiryCreate";
	}

	@GetMapping("/userInfo")
	public String userInfo(Model model) {
		UserDto userDto = userService.getUserDetails();
		model.addAttribute("user", userDto);
		return "user/userInfo";
	}

	@GetMapping("/userInfoModification")
	public String userInfoModification(Model model) {
		UserDto userDto = userService.getUserDetails();
		model.addAttribute("user", userDto);
		return "user/userInfoModification";
	}

	@PostMapping("/userInfoModification")
	public String userInfoModificationPerform(

			@ModelAttribute("user") @Valid UserDto userDto,

			@RequestParam("emailFront") String ef,

			@RequestParam("emailBack") String eb, BindingResult result) {

		if (result.hasErrors()) {
			return "userInfoModification";
		}

		userDto.setEmail(ef + "@" + eb);
		userService.update(userDto);
		return "redirect:/registration?success";

	}

}
