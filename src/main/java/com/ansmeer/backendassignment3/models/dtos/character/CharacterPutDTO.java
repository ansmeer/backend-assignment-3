package com.ansmeer.backendassignment3.models.dtos.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterPutDTO {
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private String pictureUrl;
}
