package com.library.service.admin;

import com.library.dto.admin._normal.BookDTO;
import com.library.repository.admin.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("AdminBookService")
public class BookServiceImpl implements BookService{

    @Qualifier("AdminBookRepository")
    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 모든 책 조회
    public List<BookDTO> allHavingBookManage() {
        return bookRepository.allHavingBookManage();
    }
    // 제목으로 조회
    public List<BookDTO> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }
    // 저자로 조회
    public List<BookDTO> findBookByAuthor(String author) {
        return bookRepository.findBookByAuthor(author);
    }
    // 십진분류로 조회
    public List<BookDTO> findBookByGenre(String genre) {
        return bookRepository.findBookByGenre(genre);
    }
    // 책 등록
    public void createBook(BookDTO book) {
        bookRepository.createBook(book);
    }
    // 책 수정
    public void updateBook(BookDTO book) {
        bookRepository.updateBook(book);
    }
    // 책 삭제
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }
    // 특정 도서 상세 조회
    public BookDTO getBookById(int id){
        return bookRepository.getBookById(id);
    }
    // 이전 도서 제목 조회
    public String previousBook(int id){
        return bookRepository.previousBook(id);
    }
    // 다음 도서 제목 조회
    public String nextBook(int id){
        return bookRepository.nextBook(id);
    }
}
