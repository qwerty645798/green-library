package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "rents")
@Getter
@Setter
@ToString
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rents_seq")
    @SequenceGenerator(name = "rents_seq", sequenceName = "rents_idx", allocationSize = 1)
    @Column(name = "rent_num")
    private Long rentNum;

    @Column(name = "rent_history")
    @Temporal(TemporalType.DATE)
    private Date rentHistory;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "returned")
    private Character returned;
}

