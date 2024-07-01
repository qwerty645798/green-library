package com.library.repository.admin;

import com.library.dto.admin._normal.InquiryDTO;
import com.library.dto.admin._normal.WishlistDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class AcquisitionRequestRepositoryImpl implements AcquisitionRequestRepository {

    private final JdbcTemplate jdbcTemplate;

    public AcquisitionRequestRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void setComplete(ResultSet rs, WishlistDTO wishlistDTO) throws SQLException {
        String completeStr = rs.getString("COMPLETE");
        Character complete = 'w';

        if (completeStr != null && !completeStr.isEmpty()) {
            complete = completeStr.charAt(0);
        }

        wishlistDTO.setComplete(complete);
    }

    @Override
    public List<WishlistDTO> allAcquisitionManage() {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, COMPLETE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count " +
                "FROM WISHLISTS " +
                "ORDER BY WISHLIST_ID ASC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            WishlistDTO request = new WishlistDTO();
            request.setWishlistId(rs.getInt("WISHLIST_ID"));
            request.setWishTitle(rs.getString("WISH_TITLE"));
            request.setWishAuthor(rs.getString("WISH_AUTHOR"));
            request.setWishPublisher(rs.getString("WISH_PUBLISHER"));
            request.setWishPublication(rs.getDate("WISH_PUBLICATION"));
            request.setWishPrice(rs.getInt("WISH_PRICE"));
            setComplete(rs, request);
            return request;
        });
    }

//    전체 검색
    @Override
    public List<WishlistDTO> findAcquisitionByTotal(String total) {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count " +
                "FROM WISHLISTS " +
                "WHERE WISH_TITLE LIKE ? OR WISH_AUTHOR LIKE ? " +
                "ORDER BY WISHLIST_ID ASC";
        String queryParam = "%" + total + "%";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, queryParam);
            ps.setString(2, queryParam);
            return ps;
        }, (rs, rowNum) -> {
            WishlistDTO request = new WishlistDTO();
            request.setWishlistId(rs.getInt("WISHLIST_ID"));
            request.setWishTitle(rs.getString("WISH_TITLE"));
            request.setWishAuthor(rs.getString("WISH_AUTHOR"));
            request.setWishPublisher(rs.getString("WISH_PUBLISHER"));
            request.setWishPublication(rs.getDate("WISH_PUBLICATION"));
            request.setWishPrice(rs.getInt("WISH_PRICE"));
            return request;
        });
    }

    @Override
    public List<WishlistDTO> findAcquisitionByTitle(String title) {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count " +
                "FROM WISHLISTS " +
                "WHERE WISH_TITLE LIKE '%" + title + "%' " +
                "ORDER BY WISHLIST_ID ASC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            WishlistDTO request = new WishlistDTO();
            request.setWishlistId(rs.getInt("WISHLIST_ID"));
            request.setWishTitle(rs.getString("WISH_TITLE"));
            request.setWishAuthor(rs.getString("WISH_AUTHOR"));
            request.setWishPublisher(rs.getString("WISH_PUBLISHER"));
            request.setWishPublication(rs.getDate("WISH_PUBLICATION"));
            request.setWishPrice(rs.getInt("WISH_PRICE"));
            return request;
        });
    }

    @Override
    public List<WishlistDTO> findAcquisitionByAuthor(String author) {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count " +
                "FROM WISHLISTS " +
                "WHERE WISH_AUTHOR LIKE '%" + author + "%' " +
                "ORDER BY WISHLIST_ID ASC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            WishlistDTO request = new WishlistDTO();
            request.setWishlistId(rs.getInt("WISHLIST_ID"));
            request.setWishTitle(rs.getString("WISH_TITLE"));
            request.setWishAuthor(rs.getString("WISH_AUTHOR"));
            request.setWishPublisher(rs.getString("WISH_PUBLISHER"));
            request.setWishPublication(rs.getDate("WISH_PUBLICATION"));
            request.setWishPrice(rs.getInt("WISH_PRICE"));
            return request;
        });
    }

    @Override
    public List<WishlistDTO> findAcquisitionByPublish(String publish) {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count " +
                "FROM WISHLISTS " +
                "WHERE WISH_PUBLISHER LIKE '%" + publish + "%' " +
                "ORDER BY WISHLIST_ID ASC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            WishlistDTO request = new WishlistDTO();
            request.setWishlistId(rs.getInt("WISHLIST_ID"));
            request.setWishTitle(rs.getString("WISH_TITLE"));
            request.setWishAuthor(rs.getString("WISH_AUTHOR"));
            request.setWishPublisher(rs.getString("WISH_PUBLISHER"));
            request.setWishPublication(rs.getDate("WISH_PUBLICATION"));
            request.setWishPrice(rs.getInt("WISH_PRICE"));
            return request;
        });
    }

    @Override
    public void acceptsAcquisition(List<String> requestId) {
        String sql = "UPDATE WISHLISTS SET COMPLETE = 'Y' WHERE WISHLIST_ID IN (";
        for (int i = 0; i < requestId.size(); i++) {
            sql += "'" + requestId.get(i) + "'";
            if (i < requestId.size() - 1) {
                sql += ",";
            }
        }
        sql += ")";
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteAcquisition(List<String> requestId) {
        String sql = "UPDATE WISHLISTS SET COMPLETE = 'N' WHERE WISHLIST_ID IN (";
        for (int i = 0; i < requestId.size(); i++) {
            sql += requestId.get(i);
            if (i < requestId.size() - 1) {
                sql += ",";
            }
        }
        sql += ")";
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

}
