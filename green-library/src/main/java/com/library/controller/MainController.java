package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home () {
		return "index";
	}
	
	@GetMapping("dataRule")
	public String dataRule() {
		return "dataRule";
	}
}
