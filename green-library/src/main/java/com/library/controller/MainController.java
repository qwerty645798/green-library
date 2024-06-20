package com.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.controller.user.UserController;
import com.library.dto.user.UserFindingIdDto;
import com.library.dto.user.UserJoinDto;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home() {
		return "index/index";
	}

	@GetMapping("/userJoin")
	public String userJoin(Model model) {
		model.addAttribute("userJoin", new UserJoinDto());
		logger.info("회원가입 시작");
		return "public/userJoin";
	}

	@PostMapping("/userJoin")
	public String userJoinPerform(

			@ModelAttribute("userJoin") @Valid UserJoinDto userDto,

			BindingResult result) {
		logger.info("회원가입 중간");
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> logger.error("Validation error: {}", error.getDefaultMessage()));
			return "public/userJoin";
		}
		logger.info("회원가입 후반");
		userService.insert(userDto);
		logger.info("회원가입 끝");
		return "redirect:/userLogin?success=true";
	}

	@PostMapping("/checkUserId")
    public String checkUserId(@RequestParam("user_id") String userId, Model model) {
        boolean isDuplicate = userService.checkUserId(userId);
        if (isDuplicate) {
            model.addAttribute("duplicateIdError", "아이디가 이미 존재합니다.");
        } else {
            model.addAttribute("duplicateIdSuccess", "사용 가능한 아이디입니다.");
        }
        model.addAttribute("userJoin", new UserJoinDto());
        return "public/userJoin";
    }

	@GetMapping("/userAgreement")
	public String userAgreement() {
		return "public/userAgreement";
	}

	@GetMapping("/userFinding")
	public String userFinding() {
		return "public/userFinding";
	}

	@PostMapping("/userFindingId")
	public String userFindingId(

			@ModelAttribute("user") @Valid UserFindingIdDto userDto,

			BindingResult result) {

		if (result.hasErrors()) {
			return "redirect:/userFinding";
		}

		return "redirect:/userLogin?success=true";
	}

	@PostMapping("/userFindingPw")
	public String userFindingPw() {

		return "public/userFinding";
	}

	@GetMapping("/userLogin")
	public String userLogin() {
		return "public/userLogin";
	}

	@GetMapping("/facilityInfo")
	public String facilityInfo() {
		return "facilityInfo";
	}

	@GetMapping("/privacyPolicy")
	public String privacyPolicy() {
		return "privacyPolicy";
	}

	@GetMapping("/floorInfo")
	public String floorInfo() {
		return "floorInfo";
	}

	@GetMapping("/dataRule")
	public String dataRule() {
		return "dataRule";
	}

	@GetMapping("/hopeBookApply")
	public String hopeBookApply() {
		return "hopeBookApply";
	}

	@GetMapping("/placeUsetime")
	public String placeUsetime() {
		return "placeUsetime";
	}

	@GetMapping("/wayToCome")
	public String wayToCome() {
		return "wayToCome";
	}

	// david
	@GetMapping("/bookLoanExtension")
	public String bookLoanExtension() {
		return "bookLoanExtension";
	}

	@GetMapping("/myWritten")
	public String myWritten() {
		return "myWritten";
	}

	@GetMapping("/notification")
	public String notification() {
		return "notification";
	}

	@GetMapping("/notificationDetail")
	public String notificationDetail() {
		return "notificationDetail";
	}

	@GetMapping("/vision")
	public String vision() {
		return "vision";
	}

	@GetMapping("/businessStructure")
	public String businessStructure() {
		return "businessStructure";
	}

	@GetMapping("/schedule")
	public String schedule() {
		return "schedule";
	}

	// test
	@GetMapping("/inquiryTest")
	public String inquiryTest() {
		return "inquiryTest";
	}

	@GetMapping("/missingServletRequestParam")
	public String missingServletRequestParam() {
		return "public/missingServletRequestParam";
	}
}
