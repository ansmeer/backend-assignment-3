package com.ansmeer.backendassignment3.models.dtos.movie;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Movie entity, for example in get endpoints.
 * It includes only the most basic, non-nullable fields.
 */
@Setter
@Getter
public class MovieGetSummaryDTO {
    private int id;
    private String title;
}
