package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home () {
		return "index/index";
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
	
	@GetMapping("/wayToCome")
	public String wayToCome () {
		return "wayToCome";
	}
	


	//david
	@GetMapping("/bookDetail")
	public String bookDetail () {
		return "bookDetail";
	}
	

	@GetMapping("/bookLoanExtension")
	public String bookLoanExtension () {
		return "bookLoanExtension";
	}
	
	@GetMapping("/myWritten")
	public String myWritten () {
		return "myWritten";
	}
	
	@GetMapping("/popularBook")
	public String popularBook () {
		return "popularBook";
	}
	
	@GetMapping("/initiativeBook")
	public String initiativeBook () {
		return "initiativeBook";
	}
	
	@GetMapping("/dataSearch")
	public String dataSearch () {
		return "dataSearch";
	}
	
	@GetMapping("/dataSearchResult")
	public String dataSearchResult () {
		return "dataSearchResult";
	}
	
	@GetMapping("/notification")
	public String notification () {
		return "notification";
	}
	
	@GetMapping("/vision")
	public String vision () {
		return "vision";
	}
	
	@GetMapping("/businessStructure")
	public String businessStructure () {
		return "businessStructure";
	}
	
	@GetMapping("/schedule")
	public String schedule () {
		return "schedule";
	}
	
	@GetMapping("/userCreateInquiry")
	public String userCreateInquiry () {
		return "userCreateInquiry";
	}
}
