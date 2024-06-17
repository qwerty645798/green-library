
package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookDetailController {
	
    @GetMapping("/bookDetail")
    public String bookDeatil() {
    	return "bookDeatil";
    }
}
