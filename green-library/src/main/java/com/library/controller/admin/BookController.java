package com.library.controller.admin;

import com.library.dto.admin._normal.BookDTO;
import com.library.service.admin.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("AdminBookController")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/Book")
    public String book(Model model) {
        List<BookDTO> bookDTOS = bookService.allHavingBookManage();
        model.addAttribute("bookDTOS", bookDTOS);
        return "admin/adminBook/manageBook/bookManage";
    }

    @GetMapping("/WriteBook")
    public String writeBook(Model model) {
        return "admin/adminBook/manageBook/bookWrite";
    }

    @GetMapping("/DetailBook")
    public String detailBook(Model model) {
        return "admin/adminBook/manageBook/bookDetail";
    }
}
