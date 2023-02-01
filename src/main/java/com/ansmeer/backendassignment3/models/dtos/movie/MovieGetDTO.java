package com.ansmeer.backendassignment3.models.dtos.movie;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * This class is a DTO to represent the Movie entity, for example in get endpoints.
 */
@Getter
@Setter
public class MovieGetDTO {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String pictureUrl;
    private String trailerUrl;
    private int franchise;
    private Set<Integer> characters;
}
