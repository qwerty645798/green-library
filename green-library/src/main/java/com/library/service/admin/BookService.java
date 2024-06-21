package com.library.service.admin;

import com.library.dto.admin._normal.BookDTO;

import java.util.List;

public interface BookService {

    // 모든 책 조회
    public List<BookDTO> allHavingBookManage();
    // 제목으로 조회
    public List<BookDTO> findBookByTitle(String title);
    // 저자로 조회
    public List<BookDTO> findBookByAuthor(String author);
    // 십진분류로 조회
    public List<BookDTO> findBookByGenre(String genre);
     // 책 등록
    public void createBook(BookDTO book);
     // 책 수정
    public void updateBook(BookDTO book);
     // 책 삭제
    public void deleteBook(int id);
    // 특정 도서 상세 조회
    public BookDTO getBookById(int id);
     // 이전 도서 제목 조회
    public String previousBook(int id);
    // 다음 도서 제목 조회
    public String nextBook(int id);
}
