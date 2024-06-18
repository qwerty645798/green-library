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
import com.library.service.user.UserInfoModificationService;
import com.library.service.user.UserInfoService;
import com.library.service.user.UserLoginService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserLoginService userLoginService;

	@GetMapping("/userAgreement")
	public String userAgreement() {
		return "user/userAgreement";
	}

	@GetMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}

	@GetMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}

	@GetMapping("/userFinding")
	public String userFinding() {
		return "user/userFinding";
	}

	@GetMapping("/userFindingAlt")
	public String userFindingAlt() {
		return "user/userFindingAlt";
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

	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("/userInfo")
	public String userInfo(Model model) {
		UserDto userDto = userInfoService.getUserDetails();
		model.addAttribute("user", userDto);
		return "user/userInfo";
	}

	@GetMapping("/userInfoModification")
	public String userInfoModification(Model model) {
		UserDto userDto = userInfoService.getUserDetails();
		model.addAttribute("user", userDto);
		return "user/userInfoModification";
	}

	@Autowired
	private UserInfoModificationService userInfoModificationService;

	/*
	 * @PostMapping("/userInfoModification-perform") public String
	 * userInfoModificationPerform(
	 * 
	 * @ModelAttribute("user") @Valid UserDto userDto,
	 * 
	 * @RequestParam("emailFront") String ef,
	 * 
	 * @RequestParam("emailBack") String eb, BindingResult result ) {
	 * 
	 * if (result.hasErrors()) { return "userInfoModification"; }
	 * 
	 * userDto.setEmail(ef+"@"+eb); userInfoModificationService.update(userDto);
	 * return "redirect:/registration?success";
	 * 
	 * }
	 */

}
