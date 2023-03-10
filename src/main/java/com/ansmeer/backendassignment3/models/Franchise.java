package com.ansmeer.backendassignment3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * The Franchise class represents a franchise in the movie database including its relations to other classes.
 */
@Entity
@Getter
@Setter
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String name;
    private String description;

    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
