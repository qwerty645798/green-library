package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "inquiry_responses")
@Getter
@Setter
@ToString
public class InquiryResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "response_seq")
    @SequenceGenerator(name = "response_seq", sequenceName = "response_idx", allocationSize = 1)
    @Column(name = "response_id")
    private Long responseId;

    @ManyToOne
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;

    @Column(name = "response_date")
    @Temporal(TemporalType.DATE)
    private Date responseDate;

    @Column(name = "response_content")
    private String responseContent;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}

