package com.library.controller.assets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller("AssetsBookController")
public class BookController {

	
	  @Autowired private BookDetailService bookDetailService;
	  
	  @GetMapping("/bookDetail") public String
	  bookDetail(@RequestParam(name="bookId", required = false) int bookId, Model model, 
			  @RequestParam(name = "auth", defaultValue = "abc") String userId) {
	  
	  BookDetailDto bookDetail = bookDetailService.getBookDetail(bookId);
	  model.addAttribute("book", bookDetail); 
	  model.addAttribute("userId", userId);
	  System.out.println(userId); 
	  
	  int reservationCount = bookDetailService.reservationsCount(userId);
	  model.addAttribute("reservationCount", reservationCount);
	  System.out.println(reservationCount); 
	  
	  return "bookDetail"; 
	  }
	 
    
    
    
    @Autowired
    private InitiativeBookService initiativeBookService;
    
    @GetMapping("/initiativeBook")
	public String initiativeBook (Model model) {
    	
    	List<InitiativeBookDto> initiative = initiativeBookService.getBookId();
    	model.addAttribute("items", initiative);
		return "initiativeBook";
	}
    
    @Autowired
    private PopularBookService popularBookService;
    
    @GetMapping("/popularBook")
	public String popularBook (Model model) {
    	
    	List<PopularBookDto> popular = popularBookService.getBookId();
    	model.addAttribute("items", popular);
		return "popularBook";
	}
    
    
    
    @Autowired
    private DataSearchResultService dataSearchResultService;
    
    @GetMapping("/dataSearch")
	public String dataSearch () {
		return "dataSearch";
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
    	
		return "dataSearchResult";
	}
    
}
