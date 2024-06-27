package com.library.dto.user;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishBookDto {
	private int wishId;
	private String complete;
	private Date wishDate;
	private String wishTitle;
	private String wishIsbn;
	private String wishAuthor;
	private int wishPrice;
	private String wishPublisher;
	private Date wishPublication;
}
