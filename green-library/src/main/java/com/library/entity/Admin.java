package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "admins")
@Getter
@Setter
@ToString
public class Admin {
    @Id
    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_pass")
    private String adminPass;

    @Column(name = "admin_email")
    private String adminEmail;

    @ManyToOne
    @JoinColumn(name = "grant_rank")
    private AdminGrant adminGrant;
}

