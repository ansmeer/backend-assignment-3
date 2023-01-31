package com.ansmeer.backendassignment3.models.dtos.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterGetSummaryDTO {
    private int id;
    private String fullName;
    private String alias;
}
