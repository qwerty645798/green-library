package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "admin_grants")
@Getter
@Setter
@ToString
public class AdminGrant {
    @Id
    @Column(name = "grant_rank")
    private Integer grantRank;

    @Column(name = "grant_name")
    private String grantName;
}
