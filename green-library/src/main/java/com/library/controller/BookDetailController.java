
package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.dto.BookDetailDto;

import java.sql.*;

@Controller
public class BookDetailController {
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
    String username = "springboot";
    String password = "1234";
    
    @GetMapping("/bookDetail")
    public String showBookDetail(@RequestParam(value="bookId") int bookId, Model model) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);

            // 도서 정보를 가져오는 SQL 쿼리
            String sql = "SELECT books.title, books.isbn, authors.author_name, books.img, books.location, books.availability, books.summary "
                         + "FROM books JOIN authors ON books.author_id = authors.author_id "
                         + "WHERE books.book_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	BookDetailDto book = new BookDetailDto();
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getInt("isbn"));
                book.setAuthorName(rs.getString("author_name"));
                book.setImg(rs.getString("img"));
                book.setLocation(rs.getString("location"));
                book.setAvailability(rs.getString("availability"));
                book.setSummary(rs.getString("summary"));

                if (book.getAvailability() != null) {
                    if (book.getAvailability().equals("1")) {
                        book.setAvailability("대출가능");
                    } else {
                        book.setAvailability("대출불가");
                    }
                } else {
                    book.setAvailability("알수없음");
                }

                model.addAttribute("book", book);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (pstmt != null) pstmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "bookDetail"; 
    }
}
