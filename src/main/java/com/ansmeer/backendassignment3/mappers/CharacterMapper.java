package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterGetDTO characterToCharacterDTO(Character character);

    List<CharacterGetDTO> characterToCharacterDTO(List<Character> characters);
}
