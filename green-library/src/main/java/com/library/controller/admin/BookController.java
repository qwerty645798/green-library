package com.library.controller.admin;

import com.library.dto.admin._normal.BookDTO;
import com.library.service.admin.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("AdminBookController")
@RequestMapping("/admin/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<BookDTO> getAllBooks() {
        return bookService.allHavingBookManage();
    }

    @GetMapping("/title/{title}")
    @ResponseBody
    public List<BookDTO> getBooksByTitle(@PathVariable String title) {
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/author/{author}")
    @ResponseBody
    public List<BookDTO> getBooksByAuthor(@PathVariable String author) {
        return bookService.findBookByAuthor(author);
    }

    @GetMapping("/genre/{genre}")
    @ResponseBody
    public List<BookDTO> getBooksByGenre(@PathVariable String genre) {
        return bookService.findBookByGenre(genre);
    }

    @PostMapping("/create")
    @ResponseBody
    public void createBook(@RequestBody BookDTO book) {
        bookService.createBook(book);
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateBook(@RequestBody BookDTO book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BookDTO getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/previous/{id}")
    @ResponseBody
    public String previousBook(@PathVariable int id) {
        return bookService.previousBook(id);
    }

    @GetMapping("/next/{id}")
    @ResponseBody
    public String nextBook(@PathVariable int id) {
        return bookService.nextBook(id);
    }
}
