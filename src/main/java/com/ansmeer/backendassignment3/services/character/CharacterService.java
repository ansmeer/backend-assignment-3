package com.ansmeer.backendassignment3.services.character;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.services.CrudService;

public interface CharacterService extends CrudService<Character, Integer> {
    boolean existsById(int id);

}
