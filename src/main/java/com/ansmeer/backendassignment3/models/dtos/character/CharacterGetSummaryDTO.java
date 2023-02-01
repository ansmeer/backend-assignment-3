package com.ansmeer.backendassignment3.models.dtos.character;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Character entity, for example in get endpoints.
 * It includes only the most basic fields.
 */
@Getter
@Setter
public class CharacterGetSummaryDTO {
    private int id;
    private String fullName;
    private String alias;
}
