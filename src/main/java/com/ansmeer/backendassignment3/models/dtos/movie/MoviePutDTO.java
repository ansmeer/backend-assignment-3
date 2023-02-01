package com.ansmeer.backendassignment3.models.dtos.movie;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Movie entity, for example in put endpoints.
 * It includes all properties without relationships.
 */
@Getter
@Setter
public class MoviePutDTO {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String pictureUrl;
    private String trailerUrl;
}
