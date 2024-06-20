package com.library.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.dto.user.UserDto;
import com.library.dto.user.UserInfoModificationDto;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/userInfo")
	public String userInfo(
			Model model, 
			@RequestParam(name = "auth", defaultValue = "abc") String userId
		) {
		logger.info("Received userIdPlaceholder: {}", userId);
		UserDto userDto = userService.getUserDetails(userId);
		model.addAttribute("user", userDto);
		return "user/userInfo";
	}

	@GetMapping("/userInfoModification")
	public String userInfoModification(
			Model model, 
			@RequestParam(name = "auth", defaultValue = "abc") String userId
		) {

		UserDto userDto = userService.getUserDetails(userId);
		model.addAttribute("user", userDto);
		return "user/userInfoModification";
	}

	@PostMapping("/userInfoModification")
	public String userInfoModificationPerform(
			@ModelAttribute("user") @Valid UserInfoModificationDto userInfoModificationDto, 
			@RequestParam(name = "auth", defaultValue = "abc") String userId,
			BindingResult result, 
			Model model
		) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("Validation error: {}", error.getDefaultMessage());
			}
			model.addAttribute("errors", result.getAllErrors());
			return "userInfoModification";
		}

		userService.update(userInfoModificationDto, userId);

		return "redirect:/userInfo?success=true";
	}

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

}
