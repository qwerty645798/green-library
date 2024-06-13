package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

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
	
	@GetMapping("/userInfoModification")
	public String userInfoModification() {
		return "user/userInfoModification";
	}
	
	@GetMapping("/userUseInformation")
	public String userUseInformation( 
		@RequestParam(name = "condition", required = false) String condition,
		Model model
	) {
		if(condition == null || condition.equals("rentHistory")) {
			//userService.getuserInfo(?,?,?,?,?);
			condition = "rentHistory";
		}
		else if(condition.equals("borrow")) {
			
		}
		else if(condition.equals("reserve")) {
			
		}
		else if(condition.equals("interest")) {
			
		}
		model.addAttribute("condition",condition);
		
		return "user/userUseInformation";
	}
	
	@GetMapping("/userInquiryDetail")
	public String userInquiryDetail() {
		return "user/userInquiryDetail";
	}
	
	@GetMapping("/userCreateInquiry")
	public String userCreateInquiry () {
		return "user/userCreateInquiry";
	}
}
