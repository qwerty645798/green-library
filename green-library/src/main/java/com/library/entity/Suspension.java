package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "suspensions")
@Getter
@Setter
@ToString
public class Suspension {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suspend_seq")
    @SequenceGenerator(name = "suspend_seq", sequenceName = "suspend_idx", allocationSize = 1)
    @Column(name = "suspension_id")
    private Long suspensionId;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}

