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

    /**
     * Converts a Character entity into a CharacterGetDTO.
     *
     * @param character the Character entity
     * @return the CharacterGetDTO
     */
    CharacterGetDTO characterToCharacterDto(Character character);

    /**
     * Converts a list of Character entities into a list of CharacterGetDTOs.
     *
     * @param characters the list of Character entities
     * @return the list of CharacterGetDTOs
     */
    List<CharacterGetDTO> characterToCharacterDto(List<Character> characters);

    /**
     * Converts a Character entity to a CharacterGetSummaryDTO.
     *
     * @param character the Character entity
     * @return the CharacterGetSummaryDTO
     */
    CharacterGetSummaryDTO characterToCharacterGetSummaryDto(Character character);

    /**
     * Converts a list of Character entities into a list of CharacterGetSummaryDTOs.
     *
     * @param characters the list of Character entities
     * @return the list of CharacterGetSummaryDTOs
     */
    List<CharacterGetSummaryDTO> characterToCharacterGetSummaryDto(List<Character> characters);

    /**
     * Converts a set of Character entities into a set of CharacterGetSummaryDTOs.
     *
     * @param characters the set of Character entities
     * @return the set of CharacterGetSummaryDTOs
     */
    Set<CharacterGetSummaryDTO> characterToCharacterGetSummaryDto(Set<Character> characters);

    /**
     * Converts a CharacterPostDTO into a Character entity.
     *
     * @param character the CharacterPostDTO
     * @return the Character entity
     */
    Character characterPostDtoToCharacter(CharacterPostDTO character);

    /**
     * Converts a CharacterPutDTO into a Character entity.
     *
     * @param character the CharacterPutDTO
     * @return the Character entity
     */
    Character characterPutDtoToCharacter(CharacterPutDTO character);

}
