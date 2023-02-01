package com.ansmeer.backendassignment3.models.dtos.franchise;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Movie entity, for example in get endpoints.
 */
@Getter
@Setter
public class FranchiseGetDTO {
    private int id;
    private String name;
    private String description;
}