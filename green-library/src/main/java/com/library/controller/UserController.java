package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/userJoin")
	public String userJoin() {
		return "userJoin";
	}
}
