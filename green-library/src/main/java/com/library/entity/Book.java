package com.library.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_idx", allocationSize = 1)
    @Column(name = "book_id")
    private Long bookId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "genre_fullname")
    private String genreFullname;

    @Column(name = "title")
    private String title;

    @Column(name = "img")
    private String img;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "location")
    private String location;

    @Column(name = "availability")
    private Character availability;

    @Column(name = "summary")
    private String summary;

    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Column(name = "borrow_count")
    private Integer borrowCount;
}
