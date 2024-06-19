package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class Users {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pass")
    private String userPass;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth")
    private String birth;

    @Column(name = "overdue_count")
    private Integer overdueCount;

    @Column(name = "suspended")
    private Character suspended;
}
