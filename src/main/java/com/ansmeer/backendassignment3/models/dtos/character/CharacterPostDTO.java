package com.ansmeer.backendassignment3.models.dtos.character;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Character entity, for example in post endpoints.
 * It includes all non-nullable fields.
 */
@Getter
@Setter
public class CharacterPostDTO {
    private String fullName;
}
