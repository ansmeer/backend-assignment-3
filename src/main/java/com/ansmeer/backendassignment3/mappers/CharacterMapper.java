package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPostDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPutDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterGetDTO characterToCharacterDto(Character character);

    List<CharacterGetDTO> characterToCharacterDto(List<Character> characters);

    Character characterPostDtoToCharacter(CharacterPostDTO character);

    Character characterPutDtoToCharacter(CharacterPutDTO character);

}
