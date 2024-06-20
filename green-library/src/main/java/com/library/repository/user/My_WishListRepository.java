package com.library.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.user.My_WishListDto;

@Repository
public class My_WishListRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<My_WishListDto> myWishList(String userId) {
		String sql = "SELECT wishlist_id, user_id, wish_date, wish_title, complete "
		           + "FROM wishlists "
		           + "Where user_id=?";
		           
		return jdbcTemplate.query(sql, new RowMapper<My_WishListDto>() {
			@Override
			public My_WishListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				My_WishListDto wishList = new My_WishListDto();
                wishList.setWishlistId(rs.getInt("wishlist_id"));
                wishList.setUserId(rs.getString("user_id"));
                wishList.setWishDate(rs.getDate("wish_date"));
                wishList.setWishTitle(rs.getString("wish_title")); 
                wishList.setComplete(rs.getString("complete"));
                return wishList;
			}
		}, userId);
	}
}
