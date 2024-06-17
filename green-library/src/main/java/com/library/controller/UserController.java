package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); 
	 * String id = authentication.getName();
	 */
	
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
	
	@GetMapping("/userInfoModification")
	public String userInfoModification() {
		return "user/userInfoModification";
	}
	
	@GetMapping("/userUseInformation")
	public String userUseInformation() {	
		return "user/userUseInformation";
	}
	
	@GetMapping("/useInformationBoard")
	public String useInformationBoard () {
		return "user/useInformation/board";
	}
	
	@GetMapping("/userInquiryDetail")
	public String userInquiryDetail() {
		return "user/userInquiryDetail";
	}
	
	@GetMapping("/userInquiryCreate")
	public String userInquiryCreate () {
		return "user/userInquiryCreate";
	}
	
	//@GetMapping("/logout")
	
}
