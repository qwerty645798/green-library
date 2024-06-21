package com.library.repository.admin;

import com.library.dto.admin._normal.BookDTO;
import java.util.List;

public interface BookRepository {

    // 모든 책 목록 조회
    public List<BookDTO> allHavingBookManage();

    // 제목으로 책 검색
    public List<BookDTO> findBookByTitle(String title);

    // 저자로 책 검색
    public List<BookDTO> findBookByAuthor(String authorName);

    // 십진분류로 책 검색
    public List<BookDTO> findBookByGenre(String genreFullName);

    // 책 등록
    public int createBook(BookDTO book);

    // 책 수정
    public int updateBook(BookDTO book);

    // 책 삭제
    public int deleteBook(int bookId);

    // 특정 도서 상세 조회
    public BookDTO getBookById(int bookId);

    // 이전 도서 제목 조회
    public String previousBook(int bookId);

    // 다음 도서 제목 조회
    public String nextBook(int bookId);
}
