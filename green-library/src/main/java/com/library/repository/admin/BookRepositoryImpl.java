package com.library.repository.admin;

import com.library.dto.admin._normal.BookDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Transactional
@Repository("AdminBookRepository")
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Result set 에서 대여 가능 여부를 설정
    private void setAvailability(ResultSet rs, BookDTO book) throws SQLException {
        String availabilityStr = rs.getString("AVAILABILITY");
        Character availability = null; // 기본값 설정

        if (availabilityStr != null && !availabilityStr.isEmpty()) {
            availability = availabilityStr.charAt(0); // 첫 번째 문자 char 변환
        }

        book.setAvailability(availability);
    }

    //    작가 Id 찾거나 추가하기
    private long getOrCreateAuthor(String authorName) {
        String getAuthorSql = "SELECT AUTHOR_ID FROM AUTHORS WHERE AUTHOR_NAME = ?";
        Long authorId = jdbcTemplate.queryForObject(getAuthorSql, Long.class, authorName);

        if (authorId != null) {
            return authorId;
        }

        String insertAuthorSql = "INSERT INTO AUTHORS VALUES (AUTHOR_IDX.nextval, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertAuthorSql, new String[]{"author_id"});
            ps.setString(1, authorName);
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            return generatedId.longValue();
        } else {
            throw new IllegalStateException("Generated author ID is null");
        }
    }

    // 출판사 Id 찾거나 추가하기
    private long getOrCreatePublisher(String publisherName) {
        String getPublisherSql = "SELECT PUBLISHER_ID FROM PUBLISHERS WHERE PUBLISHER_NAME = ?";
        Long publisherId = jdbcTemplate.queryForObject(getPublisherSql, Long.class, publisherName);

        if (publisherId != null) {
            return publisherId;
        }

        String insertPublisherSql = "INSERT INTO publishers VALUES (PUBLISHER_IDX.NEXTVAL, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertPublisherSql, new String[]{"publisher_id"});
            ps.setString(1, publisherName);
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            return generatedId.longValue();
        } else {
            throw new IllegalStateException("Generated publisher ID is null");
        }
    }


    // 모든 책 목록 조회
    public List<BookDTO> allHavingBookManage() {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, " +
                "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID";

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

    @Override
    public List<BookDTO> findBookByTotal(String total) {
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, " +
                "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID " +
                "WHERE BOOKS.TITLE LIKE ? OR AUTHORS.AUTHOR_NAME LIKE ? OR PUBLISHER_NAME LIKE ?";
        String queryParam = "%" + total + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            ps.setString(2, queryParam);
            ps.setString(3, queryParam);
            return ps;
        }, (rs, rowNum) -> {
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
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, " +
                "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID " +
                "WHERE TITLE LIKE ?";
        String queryParam = "%" + title + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
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
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, " +
                "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID " +
                "WHERE AUTHOR_NAME LIKE ?";
        String queryParam = "%" + authorName + "%";

        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
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
        String sql = "SELECT BOOK_ID, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, GENRE_FULLNAME, AVAILABILITY, " +
                "(SELECT COUNT(*) FROM BOOKS) AS total_count FROM BOOKS " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID " +
                "WHERE GENRE_FULLNAME LIKE ?";
        String queryParam = "%" + genreFullName + "%";

        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            return ps;
        }, (rs, rowNum) -> {
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
        long authorId = getOrCreateAuthor(book.getAuthorName());
        long publisherId = getOrCreatePublisher(book.getPublisherName());
        String sql = "INSERT INTO BOOKS (BOOK_ID, AUTHOR_ID, PUBLISHER_ID, GENRE_ID, GENRE_FULLNAME, TITLE, IMG, ISBN, LOCATION, SUMMARY, PUBLICATION_DATE) " + "VALUES (BOOK_IDX.NEXTVAL, AUTHOR_ID, PUBLISHER_ID, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, authorId, publisherId, book.getGenreId(), book.getGenreFullname(), book.getTitle(), book.getImg(), book.getIsbn(), book.getLocation(), book.getSummary(), new Date(book.getPublicationDate().getTime()));
    }

    // 책 수정
    public int updateBook(BookDTO book) {
        Long authorId = getOrCreateAuthor(book.getAuthorName());
        Long publisherId = getOrCreatePublisher(book.getPublisherName());

        String sql = "UPDATE BOOKS SET AUTHOR_ID = ?, PUBLISHER_ID = ?, GENRE_ID = ?, GENRE_FULLNAME = ?, TITLE = ?, IMG = ?, ISBN = ?, LOCATION = ?, SUMMARY = ?, PUBLICATION_DATE = ? " + "WHERE BOOK_ID = ?";
        return jdbcTemplate.update(sql, authorId, publisherId, book.getGenreId(), book.getGenreFullname(), book.getTitle(), book.getImg(), book.getIsbn(), book.getLocation(), book.getSummary(), new Date(book.getPublicationDate().getTime()), book.getBookId());
    }

    // 책 삭제
    public int deleteBook(int bookId) {
        String sql = "DELETE FROM BOOKS WHERE BOOK_ID = ?";
        return jdbcTemplate.update(sql, bookId);
    }

    // 특정 도서 상세 조회
    public BookDTO getBookById(int bookId) {
        String sql = "SELECT BOOK_ID, GENRE_FULLNAME, TITLE, AUTHOR_NAME, PUBLISHER_NAME, PUBLICATION_DATE, ISBN, LOCATION, IMG, SUMMARY " +
                "FROM BOOKS " +
                "JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
                "JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID " +
                "WHERE BOOK_ID = ?";

        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);
            return ps;
        }, rs -> {
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
        String sql = "SELECT TITLE FROM (SELECT TITLE, ROWNUM AS rnum FROM BOOKS WHERE BOOK_ID < ? ORDER BY BOOK_ID DESC) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, String.class, bookId);
    }


    // 다음 도서 제목 조회
    public String nextBook(int bookId) {
        String sql = "SELECT TITLE FROM (SELECT TITLE, ROWNUM AS rnum FROM BOOKS WHERE BOOK_ID > ? ORDER BY BOOK_ID) WHERE rnum = 1";
        return jdbcTemplate.queryForObject(sql, String.class, bookId);
    }

}
