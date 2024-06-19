package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.dto.user.UserDto;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index/index";
	}

	@GetMapping("/userAgreement")
	public String userAgreement() {
		return "public/userAgreement";
	}

	@GetMapping("/userJoin")
	public String userJoin() {
		return "public/userJoin";
	}

	@Autowired
	UserService userService;

	@PostMapping("/userJoin")
	public String userJoinPerform(

			@ModelAttribute("user") @Valid UserDto userDto,

			BindingResult result) {

		if (result.hasErrors()) {
			return "userJoin";
		}

		userService.insert(userDto);

		return "redirect:/userLogin?success=true";
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
