
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
    public String bookDetail(@RequestParam("bookId") String bookId, Model model) {
    	BookDetailDto bookDetail = bookDetailService.getBookDetail(bookId);
    	model.addAttribute("book", bookDetail);
    	return "bookDetail";
    }
}
