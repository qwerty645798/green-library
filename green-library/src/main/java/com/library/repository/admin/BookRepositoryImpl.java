package com.library.repository.admin;

import com.library.dto.admin._normal.BookDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("AdminBookRepository")
public class BookRepositoryImpl implements BookRepository{

    private final JdbcTemplate jdbcTemplate;

    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Result set 에서 대여 가능 여부를 설정
    private void setAvailability(ResultSet rs, BookDTO book) throws SQLException {
        String availabilityStr = rs.getString("AVAILABILITY");
        Character availability = null; // 기본값 설정

        if (availabilityStr != null && !availabilityStr.isEmpty()) {
            availability = availabilityStr.charAt(0); // 첫 번째 문자를 char로 변환
        }

        book.setAvailability(availability);
    }

    // 모든 책 목록 조회
    public List<BookDTO> allHavingBookManage() {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, "
                   + "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BookDTO book = new BookDTO();
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthorName(rs.getString("author_name"));
            book.setPublisherName(rs.getString("publisher_name"));
            book.setPublicationDate(rs.getDate("publication_date"));
            book.setGenreFullname(rs.getString("genre_fullname"));
            setAvailability(rs, book);
            return book;
        });
    }

    // 제목으로 책 검색
    public List<BookDTO> findBookByTitle(String title) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, "
                   + "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS WHERE TITLE LIKE ?";
        String queryParam = "%" + title + "%";

        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
            BookDTO book = new BookDTO();
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthorName(rs.getString("author_name"));
            book.setPublisherName(rs.getString("publisher_name"));
            book.setPublicationDate(rs.getDate("publication_date"));
            book.setGenreFullname(rs.getString("genre_fullname"));
            setAvailability(rs, book);
            return book;
        });
    }

    // 저자로 책 검색
    public List<BookDTO> findBookByAuthor(String authorName) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, "
                   + "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS WHERE AUTHOR_NAME LIKE ?";
        String queryParam = "%" + authorName + "%";

        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
            BookDTO book = new BookDTO();
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthorName(rs.getString("author_name"));
            book.setPublisherName(rs.getString("publisher_name"));
            book.setPublicationDate(rs.getDate("publication_date"));
            book.setGenreFullname(rs.getString("genre_fullname"));
            setAvailability(rs, book);
            return book;
        });
    }

    // 십진분류로 책 검색
    public List<BookDTO> findBookByGenre(String genreFullName) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, "
                   + "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS WHERE GENRE_FULLNAME LIKE ?";
        String queryParam = genreFullName + "%";

        return jdbcTemplate.query(sql, new Object[]{queryParam}, (rs, rowNum) -> {
            BookDTO book = new BookDTO();
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthorName(rs.getString("author_name"));
            book.setPublisherName(rs.getString("publisher_name"));
            book.setPublicationDate(rs.getDate("publication_date"));
            book.setGenreFullname(rs.getString("genre_fullname"));
            setAvailability(rs, book);
            return book;
        });
    }

    // 책 등록
    public int createBook(BookDTO book) {
        String sql = "INSERT INTO BOOKS (BOOK_ID, GENRE_FULLNAME, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, ISBN, LOCATION, IMG, SUMMARY) "
                   + "VALUES (BOOK.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, book.getGenreFullname(), book.getTitle(), book.getAuthorName(),
                                   book.getPublisherName(), book.getPublicationDate(), book.getIsbn(),
                                   book.getLocation(), book.getImg(), book.getSummary());
    }

    // 책 수정
    public int updateBook(BookDTO book) {
        String sql = "UPDATE BOOKS SET GENRE_FULLNAME = ?, TITLE = ?, AUTHOR_NAME = ?, PUBLISHER_NAME = ?, PUBLICATION_DATE = ?, "
                   + "ISBN = ?, LOCATION = ?, IMG = ?, SUMMARY = ? WHERE BOOK_ID = ?";
        return jdbcTemplate.update(sql, book.getGenreFullname(), book.getTitle(), book.getAuthorName(),
                                   book.getPublisherName(), book.getPublicationDate(), book.getIsbn(),
                                   book.getLocation(), book.getImg(), book.getSummary(), book.getBookId());
    }

    // 책 삭제
    public int deleteBook(int bookId) {
        String sql = "DELETE FROM BOOKS WHERE BOOK_ID = ?";
        return jdbcTemplate.update(sql, bookId);
    }

    // 특정 도서 상세 조회
    public BookDTO getBookById(int bookId) {
        String sql = "SELECT BOOK_ID, GENRE_FULLNAME, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, ISBN, LOCATION, IMG, SUMMARY "
                   + "FROM BOOKS WHERE BOOK_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookId}, (rs, rowNum) -> {
            BookDTO book = new BookDTO();
            book.setBookId(rs.getInt("book_id"));
            book.setGenreFullname(rs.getString("genre_fullname"));
            book.setTitle(rs.getString("title"));
            book.setAuthorName(rs.getString("author_name"));
            book.setPublisherName(rs.getString("publisher_name"));
            book.setPublicationDate(rs.getDate("publication_date"));
            book.setIsbn(rs.getString("isbn"));
            book.setLocation(rs.getString("location"));
            book.setImg(rs.getString("img"));
            book.setSummary(rs.getString("summary"));
            return book;
        });
    }

    // 이전 도서 제목 조회
    public String previousBook(int bookId) {
        String sql = "SELECT TITLE FROM BOOKS WHERE BOOK_ID < ? ORDER BY BOOK_ID DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookId}, String.class);
    }

    // 다음 도서 제목 조회
    public String nextBook(int bookId) {
        String sql = "SELECT TITLE FROM BOOKS WHERE BOOK_ID > ? ORDER BY BOOK_ID ASC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookId}, String.class);
    }
}
