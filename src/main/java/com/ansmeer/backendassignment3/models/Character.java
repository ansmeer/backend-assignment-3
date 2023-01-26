package com.ansmeer.backendassignment3.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String fullName;
    private String alias;
    private String gender;
    private String pictureUrl;

    // Relationships
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}
