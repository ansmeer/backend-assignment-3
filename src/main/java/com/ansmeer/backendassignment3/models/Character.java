package com.ansmeer.backendassignment3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String fullName;
    @Column(length = 50)
    private String alias;
    @Column(length = 20)
    private String gender;
    private String pictureUrl;

    // Relationships
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}
