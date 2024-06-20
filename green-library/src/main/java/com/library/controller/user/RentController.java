package com.library.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentController {

	//david
	@GetMapping("/myWritten")
	public String myWritten() {
		return "myWritten";
	}
	
	@GetMapping("/userInquiryCreate")
	public String userInquiryCreate() {
		return "user/userInquiryCreate";
	}

	@GetMapping("/bookLoanExtension")
	public String bookLoanExtension() {
		return "bookLoanExtension";
	}
	
}
