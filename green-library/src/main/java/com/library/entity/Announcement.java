package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "announcements")
@Getter
@Setter
@ToString
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "announce_seq")
    @SequenceGenerator(name = "announce_seq", sequenceName = "announce_idx", allocationSize = 1)
    @Column(name = "announcement_id")
    private Long announcementId;

    @Column(name = "announce_title")
    private String announceTitle;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Admin writer;

    @Column(name = "write_date")
    @Temporal(TemporalType.DATE)
    private Date writeDate;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "contents")
    private String contents;

    @Column(name = "view_count")
    private Integer viewCount;
}

