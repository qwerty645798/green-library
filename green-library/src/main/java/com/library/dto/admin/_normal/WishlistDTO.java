package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WishlistDTO {
    @NotNull
    private Long wishlistId;
    @NotNull
    private String wishTitle;
    @NotNull
    private String wishAuthor;
    @NotNull
    private String wishPublisher;
    @NotNull
    private Date wishPublication;
    @NotNull
    private Long wishPrice;
    private String wishIsbn;
    private Date wishDate;
    private Character complete;
    @NotNull
    private String userId;
}

