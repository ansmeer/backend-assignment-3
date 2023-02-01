package com.ansmeer.backendassignment3.models.dtos.character;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * This class is a DTO to represent the Character entity, for example in get endpoints.
 */
@Getter
@Setter
public class CharacterGetDTO {
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private String pictureUrl;
    private Set<Integer> movies;
}
