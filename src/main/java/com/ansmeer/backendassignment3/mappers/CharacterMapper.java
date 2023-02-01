package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetSummaryDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPostDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPutDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterGetDTO characterToCharacterDto(Character character);

    List<CharacterGetDTO> characterToCharacterDto(List<Character> characters);

    CharacterGetSummaryDTO characterToCharacterGetSummaryDto(Character character);

    List<CharacterGetSummaryDTO> characterToCharacterGetSummaryDto(List<Character> characters);

    Set<CharacterGetSummaryDTO> characterToCharacterGetSummaryDto(Set<Character> characters);

    Character characterPostDtoToCharacter(CharacterPostDTO character);

    Character characterPutDtoToCharacter(CharacterPutDTO character);

}