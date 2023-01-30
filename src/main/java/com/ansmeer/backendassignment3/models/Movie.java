package com.ansmeer.backendassignment3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(length = 100)
    private String genre;
    private int year;
    @Column(length = 50)
    private String director;
    private String pictureUrl;
    private String trailerUrl;

    // Relationships
    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")})
    private Set<Character> characters;

    @ManyToOne
    private Franchise franchise;
}
