
package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.dto.BookDetailDto;
import com.library.service.BookDetailService;


@Controller
public class BookDetailController {
	
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

	
}
