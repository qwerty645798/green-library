package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home () {
		return "index";
	}
	
	@GetMapping("/facilityInfo")
	public String facilityInfo() {
		return "facilityInfo";
	}
	
	@GetMapping("/privacyPolicy")
	public String privacyPolicy () {
		return "privacyPolicy";
	}
	
	@GetMapping("/floorInfo")
	public String floorInfo () {
		return "floorInfo";
	}
	
	@GetMapping("/dataRule")
	public String dataRule () {
		return "dataRule";
	}
	
	@GetMapping("/hopeBookApply")
	public String hopeBookApply () {
		return "hopeBookApply";
	}
	
	@GetMapping("/placeUsetime")
	public String placeUsetime () {
		return "placeUsetime";
	}
	
	@GetMapping("/bookLoanExtension")
	public String bookLoanExtension () {
		return "bookLoanExtension";
	}
	
}
