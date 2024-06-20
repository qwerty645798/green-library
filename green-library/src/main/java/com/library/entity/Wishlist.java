package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "wishlists")
@Getter
@Setter
@ToString
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wishlist_seq")
    @SequenceGenerator(name = "wishlist_seq", sequenceName = "wishlist_idx", allocationSize = 1)
    @Column(name = "wishlist_id")
    private Long wishlistId;

    @Column(name = "wish_title")
    private String wishTitle;

    @Column(name = "wish_author")
    private String wishAuthor;

    @Column(name = "wish_publisher")
    private String wishPublisher;

    @Column(name = "wish_publication")
    @Temporal(TemporalType.DATE)
    private Date wishPublication;

    @Column(name = "wish_price")
    private Integer wishPrice;

    @Column(name = "wish_isbn")
    private String wishIsbn;

    @Column(name = "wish_date")
    @Temporal(TemporalType.DATE)
    private Date wishDate;

    @Column(name = "complete")
    private Character complete;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}

