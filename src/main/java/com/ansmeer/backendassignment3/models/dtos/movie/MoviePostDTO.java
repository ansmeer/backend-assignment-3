package com.ansmeer.backendassignment3.models.dtos.movie;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Movie entity, for example in post endpoints.
 * It includes all non-nullable fields.
 */
@Getter
@Setter
public class MoviePostDTO {
    private String title;
}
