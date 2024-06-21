package com.library.repository.admin;

import com.library.dto.admin._normal.WishlistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcquisitionRequestRepositoryImpl implements AcquisitionRequestRepository {

    private final JdbcTemplate jdbcTemplate;

    public AcquisitionRequestRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WishlistDTO> allAcquisitionManage() {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count\n" +
                "FROM WISHLISTS\n";
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
    public List<WishlistDTO> findAcquisitionByTitle(String title) {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count\n" +
                "FROM WISHLISTS\n" +
                "WHERE WISH_TITLE LIKE '%" + title + "%'";
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
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count\n" +
                "FROM WISHLISTS\n" +
                "WHERE WISH_AUTHOR LIKE '%" + author + "%'";
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
    public List<WishlistDTO> findAcquisitionByGenre(String genre) {
        String sql = "SELECT WISHLIST_ID, WISH_TITLE, WISH_AUTHOR, WISH_PUBLISHER, WISH_PUBLICATION, WISH_PRICE, (SELECT COUNT(*) FROM WISHLISTS) AS total_count\n" +
                "FROM WISHLISTS\n" +
                "WHERE genreFullname LIKE '%" + genre + "%'";
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
    public void acceptsAcquisition(Integer requestId) {
        String sql = "UPDATE WISHLISTS SET REQUEST_STATUS = ? WHERE REQUEST_ID = ?";
        String complete = "1";
        jdbcTemplate.update(sql, complete, requestId);
    }

    @Override
    public void deleteAcquisition(Integer requestId) {
        String sql = "DELETE FROM WISHLISTS WHERE REQUEST_ID = ?";
        jdbcTemplate.update(sql, requestId);
    }
}
