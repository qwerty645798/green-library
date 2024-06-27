package com.library.controller.admin;

import com.library.dto.admin._normal.BookDTO;
import com.library.dto.admin._normal.UserDTO;
import com.library.service.admin.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("AdminBookController")
@RequestMapping("/Book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    onload
    @GetMapping()
    public String book(Model model) {
        List<BookDTO> bookDTOS = bookService.allHavingBookManage();
        model.addAttribute("bookDTOS", bookDTOS);
        return "admin/adminBook/manageBook/bookManage";
    }

//    검색
    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooks(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

        List<BookDTO> books;

        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            books = bookService.allHavingBookManage();
        } else {
            books = switch (searchType) {
                case "title" -> bookService.findBookByTitle(searchKeyword);
                case "author" -> bookService.findBookByAuthor(searchKeyword);
                case "genre" -> bookService.findBookByGenre(searchKeyword);
                default -> bookService.findBookByTotal(searchKeyword);
            };
        }
        return ResponseEntity.ok(books);
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
