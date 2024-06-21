package com.library.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.dto.user.UserInfoDTO;
import com.library.dto.user.UserInfoModificationDTO;
import com.library.dto.user.UserRentHistoryDTO;
import com.library.service.user.InquiryService;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller("UserController")
//@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	@Qualifier("UserService")
	private UserService userService;
	
	@Autowired
	@Qualifier("UserInquiryService")
	private InquiryService inquiryService;

	@GetMapping("/userInfo")
	public String userInfo(Model model, @RequestParam(name = "auth", defaultValue = "abc") String userId) {
		logger.info("Received auth: {}", userId);
		UserInfoDTO userDTO = userService.getUserInfo(userId);
		model.addAttribute("userInfo", userDTO);
		return "user/userInfo";
	}

	@GetMapping("/userInfoModification")
	public String userInfoModification(Model model, @RequestParam(name = "auth", defaultValue = "abc") String userId) {

		UserInfoDTO userDTO = userService.getUserInfo(userId);
		model.addAttribute("userInfo", userDTO);
		return "user/userInfoModification";
	}

	@PostMapping("/userInfoModification")
	public String userInfoModificationPerform(
			@ModelAttribute("userInfo") @Valid UserInfoModificationDTO userInfoModificationDTO,
			@RequestParam(name = "auth", defaultValue = "abc") String userId, BindingResult result, 
			Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("Validation error: {}", error.getDefaultMessage());
			}
			model.addAttribute("message", "유효하지 않은 입력입니다.");
			return "userInfoModification";
		}

		userService.update(userInfoModificationDTO, userId);
		redirectAttributes.addFlashAttribute("message","회원정보가 수정되었습니다.");
		return "redirect:/userInfo";
	}
	
	@PostMapping("/userDelete")
	public String userDelete(@RequestParam(name = "auth", defaultValue = "abc") String userId, RedirectAttributes redirectAttributes) {
		userService.deleteUser(userId);
		redirectAttributes.addFlashAttribute("message","userDelete");
		return "redirect:/";
	}

	@GetMapping("/userUseInformation")
	public String userUseInformation(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("condition") String condition, Model model) {
		List<?> list;
		if(condition == "rentHistory" || condition == "") {
			list = inquiryService.getUserRentHistory(userId);
		}
		else if(condition == "borrow") {
			list = inquiryService.getUserBorrow(userId);
		}
		else if(condition == "reserve") {
			list = inquiryService.getUserReserve(userId);
		}
		else if(condition == "interest") {
			list = inquiryService.getUserInterestDTO(userId);
		}
		model.addAttribute("list", list);
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



}
