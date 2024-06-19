package com.library.repository.admin;

import com.library.dto.admin._normal.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 모든 도서 목록 조회
    public List<BookDTO> getAllBooks() {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, " +
                "AVAILABILITY, (SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS";
        return jdbcTemplate.query(sql, new RowMapper<BookDTO>() {
            @Override
            public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BookDTO book = new BookDTO();
                book.setBookId(rs.getInt("BOOK_ID"));
                book.setTitle(rs.getString("TITLE"));
                book.setAuthorName(rs.getString("AUTHOR_NAME"));
                book.setPublisherName(rs.getString("PUBLISHER_NAME"));
                book.setPublicationDate(rs.getDate("PUBLICATION_DATE"));
                book.setGenreFullname(rs.getString("GENRE_FULLNAME"));
                setAvailability(rs, book);
                book.setBorrowCount(rs.getInt("total_count"));
                return book;
            }
        });
    }

    // 제목으로 도서 검색
    public List<BookDTO> searchByTitle(String title) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, " +
                "AVAILABILITY, (SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS " +
                "WHERE TITLE LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + title + "%"}, new RowMapper<BookDTO>() {
            @Override
            public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BookDTO book = new BookDTO();
                book.setBookId(rs.getInt("BOOK_ID"));
                book.setTitle(rs.getString("TITLE"));
                book.setAuthorName(rs.getString("AUTHOR_NAME"));
                book.setPublisherName(rs.getString("PUBLISHER_NAME"));
                book.setPublicationDate(rs.getDate("PUBLICATION_DATE"));
                book.setGenreFullname(rs.getString("GENRE_FULLNAME"));
                setAvailability(rs, book);
                book.setBorrowCount(rs.getInt("total_count"));
                return book;
            }
        });
    }

    // 저자로 도서 검색
    public List<BookDTO> searchByAuthor(String author) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, " +
                "AVAILABILITY, (SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS " +
                "WHERE AUTHOR_NAME LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + author + "%"}, new RowMapper<BookDTO>() {
            @Override
            public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BookDTO book = new BookDTO();
                book.setBookId(rs.getInt("BOOK_ID"));
                book.setTitle(rs.getString("TITLE"));
                book.setAuthorName(rs.getString("AUTHOR_NAME"));
                book.setPublisherName(rs.getString("PUBLISHER_NAME"));
                book.setPublicationDate(rs.getDate("PUBLICATION_DATE"));
                book.setGenreFullname(rs.getString("GENRE_FULLNAME"));
                setAvailability(rs, book);
                book.setBorrowCount(rs.getInt("total_count"));
                return book;
            }
        });
    }

    // 장르로 도서 검색
    public List<BookDTO> searchByGenre(String genre) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, " +
                "AVAILABILITY FROM BOOKS " +
                "WHERE GENRE_FULLNAME LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{genre + "%"}, new RowMapper<BookDTO>() {
            @Override
            public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BookDTO book = new BookDTO();
                book.setBookId(rs.getInt("BOOK_ID"));
                book.setTitle(rs.getString("TITLE"));
                book.setAuthorName(rs.getString("AUTHOR_NAME"));
                book.setPublisherName(rs.getString("PUBLISHER_NAME"));
                book.setPublicationDate(rs.getDate("PUBLICATION_DATE"));
                book.setGenreFullname(rs.getString("GENRE_FULLNAME"));
                setAvailability(rs, book);
                return book;
            }
        });
    }

    // 도서 상세 정보 조회
    public BookDTO getBookById(Long bookId) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, " +
                "AVAILABILITY FROM BOOKS WHERE BOOK_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookId}, new RowMapper<BookDTO>() {
            @Override
            public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BookDTO book = new BookDTO();
                book.setBookId(rs.getInt("BOOK_ID"));
                book.setTitle(rs.getString("TITLE"));
                book.setAuthorName(rs.getString("AUTHOR_NAME"));
                book.setPublisherName(rs.getString("PUBLISHER_NAME"));
                book.setPublicationDate(rs.getDate("PUBLICATION_DATE"));
                book.setGenreFullname(rs.getString("GENRE_FULLNAME"));
                setAvailability(rs, book);
                return book;
            }
        });
    }

    // 도서 등록
    public void createBook(BookDTO bookDTO) {
        String sql = "INSERT INTO BOOKS (BOOK_ID, GENRE_FULLNAME, TITLE, AUTHOR_NAME, PUBLISHER_NAME, " +
                "PUBLICATION_DATE, ISBN, LOCATION, IMG, SUMMARY) VALUES (BOOK.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, bookDTO.getGenreFullname(), bookDTO.getTitle(), bookDTO.getAuthorName(),
                bookDTO.getPublisherName(), bookDTO.getPublicationDate(), bookDTO.getIsbn(),
                bookDTO.getLocation(), bookDTO.getImg(), bookDTO.getSummary());
    }

    // 도서 정보 업데이트
    public void updateBook(BookDTO bookDTO) {
        String sql = "UPDATE BOOKS SET GENRE_FULLNAME = ?, TITLE = ?, AUTHOR_NAME = ?, PUBLISHER_NAME = ?, " +
                "PUBLICATION_DATE = ?, ISBN = ?, LOCATION = ?, IMG = ?, SUMMARY = ? WHERE BOOK_ID = ?";
        jdbcTemplate.update(sql, bookDTO.getGenreFullname(), bookDTO.getTitle(), bookDTO.getAuthorName(),
                bookDTO.getPublisherName(), bookDTO.getPublicationDate(), bookDTO.getIsbn(),
                bookDTO.getLocation(), bookDTO.getImg(), bookDTO.getSummary(), bookDTO.getBookId());
    }

    // 도서 삭제
    public void deleteBook(Long bookId) {
        String sql = "DELETE FROM BOOKS WHERE BOOK_ID = ?";
        jdbcTemplate.update(sql, bookId);
    }

    // 도서 대여 가능 여부 업데이트
    public void updateBookAvailability(Long bookId, boolean availability) {
        String sql = "UPDATE BOOKS SET AVAILABILITY = ? WHERE BOOK_ID = ?";
        jdbcTemplate.update(sql, availability ? "Y" : "N", bookId);
    }

    // ResultSet에서 대여 가능 여부를 설정
    private void setAvailability(ResultSet rs, BookDTO book) throws SQLException {
        String availabilityStr = rs.getString("AVAILABILITY");

        Character availability = null; // 기본값 설정

        if (availabilityStr != null && !availabilityStr.isEmpty()) {
            availability = availabilityStr.charAt(0); // 첫 번째 문자를 Character로 변환
        }

        book.setAvailability(availability);
    }

    // 이전 도서 제목 조회
    public String findPreviousBookTitle(Integer bookId) {
        String sql = "SELECT TITLE FROM BOOKS WHERE BOOK_ID < ? ORDER BY BOOK_ID DESC";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookId}, String.class);
    }

    // 다음 도서 제목 조회
    public String findNextBookTitle(Integer bookId) {
        String sql = "SELECT TITLE FROM BOOKS WHERE BOOK_ID > ? ORDER BY BOOK_ID ASC";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookId}, String.class);
    }
}
