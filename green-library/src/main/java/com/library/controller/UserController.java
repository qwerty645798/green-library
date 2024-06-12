package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

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
	
	@GetMapping("/userUseInformation")
	public String userUseInformation() {
		return "user/userUseInformation";
	}
}
