package com.ansmeer.backendassignment3.models.dtos.movie;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MovieGetCharactersDTO {
    private int id;
    private Set<Integer> characters;
}
