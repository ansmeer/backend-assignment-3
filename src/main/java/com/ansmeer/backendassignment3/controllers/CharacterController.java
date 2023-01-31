package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.mappers.CharacterMapper;
import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPostDTO;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterPutDTO;
import com.ansmeer.backendassignment3.services.character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
    public ResponseEntity<CharacterGetDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDto(
                        characterService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CharacterGetDTO>> getAll() {
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDto(
                        characterService.findAll())
        );
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody CharacterPostDTO character) throws URISyntaxException {
        Character newCharacter = characterService.add(
                characterMapper.characterPostDtoToCharacter(character));
        //URI uri = URI.create("api/v1/characters/" + newCharacter.getId());
        URI uri = new URI("api/v1/characters/" + newCharacter.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
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
    public ResponseEntity<Object> delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
