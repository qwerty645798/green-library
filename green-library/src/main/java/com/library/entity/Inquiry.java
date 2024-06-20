package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "inquiries")
@Getter
@Setter
@ToString
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inquiry_seq")
    @SequenceGenerator(name = "inquiry_seq", sequenceName = "inquiry_idx", allocationSize = 1)
    @Column(name = "inquiry_id")
    private Long inquiryId;

    @Column(name = "inquiry_title")
    private String inquiryTitle;

    @Column(name = "contents")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}

