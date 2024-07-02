package com.library.controller.user;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.dto.user.BookLoanExtensionDto;
import com.library.dto.user.My_InquiryDto;
import com.library.dto.user.My_WishListDto;
import com.library.dto.user.WishBookDto;
import com.library.dto.user.rewriteWishBookDto;
import com.library.service.assets.BookDetailService;
import com.library.service.user.BookLoanExtensionService;
import com.library.service.user.HopeBookApplyService;
import com.library.service.user.My_WrittenService;
import com.library.service.user.UserCreateInquiryService;
import com.library.service.user.WishBookService;
import com.library.service.user.rewriteWishBookService;

@Controller("UserRentController")
@RequestMapping("/user")
public class RentController {

	@Autowired
	private My_WrittenService my_WrittenService;
	
	@GetMapping("/myWritten")
	public String myWritten(@RequestParam(name = "auth", defaultValue = "abc") String userId , Model model) {
		
	    
		List<My_InquiryDto> inquiryList = my_WrittenService.getMyInquiryList(userId);
		List<My_WishListDto> wishList = my_WrittenService.getMyWishList(userId);
		
		model.addAttribute("inquiries", inquiryList);
		model.addAttribute("wishLists", wishList);
		
		return "user/myWritten";
	}
	
	
	@GetMapping("/userInquiryCreate")
	public String userInquiryCreate(@RequestParam(name = "auth", defaultValue = "abc") String userId,  Model model) {
		
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
    	
    	return "redirect:/user/myWritten";
    }
	
	@Autowired
	private BookLoanExtensionService bookLoanExtensionService;
	
	@GetMapping("/bookLoanExtension")
	public String bookLoanExtension(@RequestParam(name = "auth", defaultValue = "abc") String userId, Model model) {
		
		List<BookLoanExtensionDto> extensions = bookLoanExtensionService.getLoanList(userId);
		model.addAttribute("extensions", extensions);
		model.addAttribute("userId", userId);
		
		boolean loanExist = bookLoanExtensionService.allLoanList(userId);
	    model.addAttribute("loanExist", loanExist);
	    
		return "user/bookLoanExtension";
	}

	@PostMapping("/bookExtension")
	public String bookExtension(@RequestParam(name="bookId", required = false) int bookId) {
		
		bookLoanExtensionService.getExtension(bookId);
		
		return "redirect:/user/bookLoanExtension";
	}
	
	@PostMapping("/bookExtensionBatch")
	public String bookExtensionBatch(@RequestParam(name = "bookIds") List<Integer> bookIds) {
	    for (int bookId : bookIds) {
	        bookLoanExtensionService.getExtension(bookId);
	    }
	    return "redirect:/user/bookLoanExtension";
	}
	
	
	@Autowired
	private BookDetailService bookDetailService;
	
	@PostMapping("/reserveBook")
    public String reserveBook(@RequestParam(name = "auth", defaultValue = "abc") String userId, 
    		@RequestParam(name="bookId", required = false) int bookId, RedirectAttributes redirectAttributes ) {
    	
    	bookDetailService.makeReservation(bookId, userId);
    	bookDetailService.changeAvailability(bookId);
    	redirectAttributes.addFlashAttribute("message", "예약이 완료되었습니다.");
    	return "redirect:/bookDetail?bookId=" + bookId;
    }
	
	@Autowired
	private WishBookService wishBookService;
	
	@GetMapping("/wishBook")
	public String wishBook(@RequestParam(name = "auth", defaultValue = "abc") String userId, Model model,
			 @RequestParam(name="wishId", required = false) int wishId) {
		
		WishBookDto wishbook = wishBookService.getWishBookDetail(wishId);
		model.addAttribute("wishs", wishbook);
		model.addAttribute("userId", userId);
		
		return "user/wishBook";
	}
	
	@PostMapping("/deleteWish")
	public String deleteWish(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam(name = "wishlistId") int wishlistId) {
		
		wishBookService.deleteWishBook(wishlistId, userId);		
		
		return "redirect:/user/myWritten";
	}
	
	
	
	@GetMapping("/hopeBookApply")
	public String hopeBookApply(@RequestParam(name = "auth", defaultValue = "abc") String userId, Model model) {
		
		model.addAttribute("userId", userId);
		return "user/hopeBookApply";
	}
	
	@Autowired
	private rewriteWishBookService RewriteWishBookService;
	
	@GetMapping("/rewriteWishBook")
	public String rewriteWishBook(@RequestParam(name = "auth", defaultValue = "abc") String userId, Model model,
			 @RequestParam(name="wishId", required = false) int wishId) {
		
		rewriteWishBookDto wishBook = RewriteWishBookService.getWishDetail(wishId);
		model.addAttribute("wishBook", wishBook);
		model.addAttribute("userId", userId);
		
		return "user/rewriteWishBook";
	}
	
	@PostMapping("/rewriteWishBooks")
	public String rewriteWishBooks(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam(name="wishId", required = false) int wishlistId, 
    		@RequestParam("wishTitle") String wishTitle, @RequestParam("wishAuthor") String wishAuthor,
    		@RequestParam("wishPublisher") String wishPublisher, @RequestParam("wishPublication") Date wishPublication,
    		@RequestParam("wishPrice") int wishPrice, @RequestParam("wishIsbn") String wishIsbn) {
    	
		RewriteWishBookService.updateWishs(wishTitle, wishAuthor, wishPublisher, wishPublication, wishPrice, wishIsbn, wishlistId, userId);
    	
    	return "redirect:/user/myWritten";
    }
	
	
	@Autowired
	private HopeBookApplyService hopeBookApplyService; 
	
	@PostMapping("/wishCreate")
	public String inquiryCreate(@RequestParam(name = "auth", defaultValue = "abc") String userId,
    		@RequestParam("wishTitle") String wishTitle, @RequestParam("wishAuthor") String wishAuthor,
    		@RequestParam("wishPublisher") String wishPublisher, @RequestParam("wishPublication") Date wishPublication,
    		@RequestParam("wishPrice") int wishPrice, @RequestParam("wishIsbn") String wishIsbn) {
    	
		hopeBookApplyService.createWish(userId, wishTitle, wishAuthor, wishPublisher, wishPublication, wishPrice, wishIsbn);
    	
    	return "redirect:/user/myWritten";
    }
	
	@GetMapping("/modifyInquiry")

    public String modifyInquiry(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam(name = "inquiryId", defaultValue = "error") String id, Model model) {
    	model.addAttribute("userId", userId);
    	return "user/userInquiryModify";
    }
    
    @PostMapping("/modifyInquiry")
    public String modifyInquiryPerform(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam(name = "inquiryId", defaultValue = "error") String id, RedirectAttributes redirectAttributes, 
    		@RequestParam("inquiry_title") String inquiryTitle,
    		@RequestParam("contents") String contents) {
    	if(id.equals("error"))
    		return "redirect:/user/myWritten";
    	userCreateInquiryService.modifyInquiry(inquiryTitle, contents, userId, id);
    	redirectAttributes.addFlashAttribute("message","문의내역이 수정되었습니다.");
    	return "redirect:/user/myWritten";
    }
    
    @GetMapping("/deleteInquiry")
    public String deleteInquiry(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam(name = "inquiryId", defaultValue = "error") String id, RedirectAttributes redirectAttributes) {
    	if(id.equals("error"))
    		return "redirect:/user/myWritten";
    	userCreateInquiryService.deleteInquiry(userId, id);
    	redirectAttributes.addFlashAttribute("message","문의내역이 삭제되었습니다.");
    	return "redirect:/user/myWritten";
    }
	
}
