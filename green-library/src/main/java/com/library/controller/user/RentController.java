package com.library.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.dto.user.BookLoanExtensionDto;
import com.library.dto.user.My_InquiryDto;
import com.library.dto.user.My_WishListDto;
import com.library.service.user.BookLoanExtensionService;
import com.library.service.user.My_WrittenService;
import com.library.service.user.UserCreateInquiryService;

@Controller("UserRentController")
public class RentController {

	@Autowired
	private My_WrittenService my_WrittenService;
	
	@GetMapping("/myWritten")
	public String myWritten(@RequestParam(name="bookId", required = false) String bookId, Model model, 
    		@RequestParam(name = "auth", defaultValue = "abc") String userId) {
		
		List<My_InquiryDto> inquiryList = my_WrittenService.getMyInquiryList(userId);
		List<My_WishListDto> wishList = my_WrittenService.getMyWishList(userId);
		
		model.addAttribute("inquiries", inquiryList);
		model.addAttribute("wishLists", wishList);
		
		return "myWritten";
	}
	
	@GetMapping("/userInquiryCreate")
	public String userInquiryCreate( Model model, @RequestParam(name = "auth", defaultValue = "abc") String userId) {
		model.addAttribute("userId", userId);
		return "user/userInquiryCreate";
	}

	@Autowired
	private UserCreateInquiryService userCreateInquiryService;
	
	@PostMapping("/inquiryCreate")
    public String inquiryCreate(@RequestParam(name = "auth", defaultValue = "abc") String userId,
    		@RequestParam("inquiry_title") String inquiryTitle,
    		@RequestParam("contents") String contents) {
    	
    	userCreateInquiryService.createInquiry(userId, inquiryTitle, contents);
    	
    	return "myWritten";
    }
	
	@Autowired
	private BookLoanExtensionService bookLoanExtensionService;
	
	@GetMapping("/bookLoanExtension")
	public String bookLoanExtension(@RequestParam(name = "auth", defaultValue = "abc") String userId, Model model) {
		List<BookLoanExtensionDto> extensions = bookLoanExtensionService.getLoanList(userId);
		
	    
		model.addAttribute("extensions", extensions);
		model.addAttribute("userId", userId);
		return "bookLoanExtension";
	}

	@PostMapping("/bookExtension")
	public String bookExtension(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		
		bookLoanExtensionService.getExtension(userId);
		return "bookLoanExtension";
	}
	
	
}
