package com.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "genres")
@Getter
@Setter
@ToString
public class Genre {
    @Id
    @Column(name = "genre_id")
    private String genreId;

    @Column(name = "genre_name")
    private String genreName;
}
