package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_genres")
@Getter
@Setter
@ToString
public class UserGenre {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
