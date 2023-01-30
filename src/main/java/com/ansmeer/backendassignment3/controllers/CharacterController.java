package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.services.character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Character character) {
        Character newCharacter = characterService.add(character);
        URI uri = URI.create("characters/" + newCharacter.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Character character, @PathVariable int id) {
        if (character.getId() != id)
            return ResponseEntity.badRequest().build();
        characterService.update(character);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (!characterService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
