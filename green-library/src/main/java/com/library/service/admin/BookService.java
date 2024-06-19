package com.library.service.admin;

import com.library.dto.admin._normal.*;
import com.library.repository.admin.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 모든 도서 목록 조회
    public List<BookDTO> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // 제목으로 검색한 도서 목록 조회
    public List<BookDTO> getBooksByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    public List<BookDTO> getBooksByAuthor(String author) {
        return bookRepository.searchByAuthor(author);
    }

    public List<BookDTO> getGenre(String genre) {
        return bookRepository.searchByGenre(genre);
    }

    // 도서 상세 정보 조회
    public BookDTO getBookById(Long bookId) {
        return bookRepository.getBookById(bookId);
    }

    // 도서 등록
    @Transactional
    public void createBook(BookDTO bookDTO) {
        bookRepository.createBook(bookDTO);
    }

    // 도서 정보 업데이트
    @Transactional
    public void updateBook(BookDTO bookDTO) {
        bookRepository.updateBook(bookDTO);
    }

    // 도서 삭제
    @Transactional
    public void deleteBook(Long bookId) {
        bookRepository.deleteBook(bookId);
    }

    // 도서 대여 가능 여부 업데이트
    @Transactional
    public void updateBookAvailability(Long bookId, boolean availability) {
        bookRepository.updateBookAvailability(bookId, availability);
    }
}
