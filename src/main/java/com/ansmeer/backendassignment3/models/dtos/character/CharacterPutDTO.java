package com.ansmeer.backendassignment3.models.dtos.character;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Character entity, for example in put endpoints.
 * It includes all properties without relationships.
 */
@Getter
@Setter
public class CharacterPutDTO {
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private String pictureUrl;
}
