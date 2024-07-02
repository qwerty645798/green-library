package com.library.controller.assets;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.dto.assets.BookDetailDto;
import com.library.dto.assets.DataSearchResultDto;
import com.library.dto.assets.InitiativeBookDto;
import com.library.dto.assets.PopularBookDto;
import com.library.service.assets.BookDetailService;
import com.library.service.assets.DataSearchResultService;
import com.library.service.assets.InitiativeBookService;
import com.library.service.assets.PopularBookService;
import com.library.service.user.InquiryService;

@Controller("AssetsBookController")
public class BookController {

	@Autowired private BookDetailService bookDetailService;
	
	@Autowired
	@Qualifier("UserInquiryService")
	private InquiryService inquiryService;
  
	@GetMapping("/bookDetail") public String
	bookDetail(@RequestParam(name="bookId", required = false) int bookId, Model model ) {
		  			
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		  
		  if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
			    // 로그인된 상태에서는 실제 사용자의 아이디를 가져옴
			  String userId = authentication.getName();
			  model.addAttribute("userId", userId);
			  
			  boolean interest = inquiryService.getUserInterest(userId, bookId);
			  model.addAttribute("checkInterest",interest);
			  
			  int reservationCount = bookDetailService.reservationsCount(userId);
			  model.addAttribute("reservationCount", reservationCount);
		  }					 
		        
		  BookDetailDto bookDetail = bookDetailService.getBookDetail(bookId);
		  model.addAttribute("book", bookDetail); 
		  
		  boolean canReserve = bookDetailService.canReserveBook(bookId, authentication.getName());
	      model.addAttribute("canReserve", canReserve);
	      
	      
	        
		  return "public/bookDetail"; 
	}
	 
    
    
    
    @Autowired
    private InitiativeBookService initiativeBookService;
    
    @GetMapping("/initiativeBook")
	public String initiativeBook (Model model) {
    	
    	List<InitiativeBookDto> initiative = initiativeBookService.getBookId();
    	model.addAttribute("items", initiative);
		return "public/initiativeBook";
	}
    
    @Autowired
    private PopularBookService popularBookService;
    
    @GetMapping("/popularBook")
	public String popularBook (Model model) {
    	
    	List<PopularBookDto> popular = popularBookService.getBookId();
    	model.addAttribute("items", popular);
		return "public/popularBook";
	}
    
    
    
    @Autowired
    private DataSearchResultService dataSearchResultService;
    
    @GetMapping("/dataSearch")
	public String dataSearch () {
		return "public/dataSearch";
	}
	
	@GetMapping("/dataSearchResult")
	public String dataSearchResult (@RequestParam(name = "inputCategory", required = false) String inputCategory,
            @RequestParam(name = "inputText", required = false) String inputText, 
            @RequestParam(name = "itemsPerPage", required = false, defaultValue = "5") int itemsPerPage, 
            Model model) {
		
		if((inputCategory==null)&&(inputText==null)) {
    		return "redirect:/";
    	}
		
		List<DataSearchResultDto> dataSearch = dataSearchResultService.getBookId(inputCategory, inputText);
    	model.addAttribute("items", dataSearch);
    	model.addAttribute("inputCategory", inputCategory);
    	model.addAttribute("inputText", inputText);
    	model.addAttribute("itemsPerPage", itemsPerPage);
    	
		return "public/dataSearchResult";
	}
    
}
