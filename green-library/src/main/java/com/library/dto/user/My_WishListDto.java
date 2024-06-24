package com.library.dto.user;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class My_WishListDto {
	private int wishlistId;
	private String userId;
	private Date wishDate;
	private String wishTitle;
	private String complete;
	
}
