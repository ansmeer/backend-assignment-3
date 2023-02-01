package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.mappers.CharacterMapper;
import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPostDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPutDTO;
import com.ansmeer.backendassignment3.services.character.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Handles all api requests related to characters
 * under the base uri "api/v1/characters".
 */
@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a character by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CharacterGetDTO.class))),
            @ApiResponse(responseCode = "404", description = "Character not found", content = @Content)
    })
    public ResponseEntity<CharacterGetDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDto(
                        characterService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Get all characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CharacterGetDTO.class)))})
    })
    public ResponseEntity<List<CharacterGetDTO>> getAll() {
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDto(
                        characterService.findAll())
        );
    }

    @PostMapping
    @Operation(summary = "Add a character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content)
    })
    public ResponseEntity<Object> add(@RequestBody CharacterPostDTO character) throws URISyntaxException {
        Character newCharacter = characterService.add(
                characterMapper.characterPostDtoToCharacter(character));
        URI uri = new URI("api/v1/characters/" + newCharacter.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Character updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request, URI does not match request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Character not found", content = @Content),
    })
    public ResponseEntity<Object> update(@RequestBody CharacterPutDTO character, @PathVariable int id) {
        if (character.getId() != id) {
            return ResponseEntity.badRequest().build();
        }
        characterService.update(
                characterMapper.characterPutDtoToCharacter(character)
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a character by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Character deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Character not found", content = @Content)
    })
    public ResponseEntity<Object> delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
