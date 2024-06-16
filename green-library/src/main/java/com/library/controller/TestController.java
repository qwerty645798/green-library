package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@PostMapping("/inquiryTest")
	public String processInquiry(
			@RequestParam("user_id") String user_id,
			@RequestParam("inquiry_title") String  inquiry_title,
			@RequestParam("contents") String contents){
		
		
		
		return "redirect:/myWritten";
	}
}
