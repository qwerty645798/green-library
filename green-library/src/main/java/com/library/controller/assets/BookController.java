package com.library.controller.assets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.dto.assets.BookDetailDto;
import com.library.dto.assets.InitiativeBookDto;
import com.library.service.assets.BookDetailService;
import com.library.service.assets.InitiativeBookService;

@Controller
public class BookController {

	@Autowired
	private BookDetailService bookDetailService;
	
    @GetMapping("/bookDetail")
    public String bookDetail(@RequestParam(name="bookId", required = false) String bookId, Model model) {
    	
    	if(bookId==null) {
    		return "redirect:/";
    	}//리퀘파람 펄스 + 리다이렉트로 직접 bookdetail로 이동(bookId=null)은 인덱스로 돌려보냄
    	
    	BookDetailDto bookDetail = bookDetailService.getBookDetail(bookId);
    	model.addAttribute("book", bookDetail);
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
    
    
    @GetMapping("/popularBook")
	public String popularBook () {
		return "popularBook";
	}
    
}
