package com.ansmeer.backendassignment3.services.character;

import com.ansmeer.backendassignment3.exceptions.ElementNotFoundException;
import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.repositories.CharacterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class describes an implementation of the character service interface
 * and interacts with different repositories.
 */
@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Character findById(Integer id) {
        return repository.findById(id).orElseThrow(()
                -> new ElementNotFoundException(id, "character"));
    }

    @Override
    public List<Character> findAll() {
        return repository.findAll();
    }

    @Override
    public Character add(Character character) {
        return repository.save(character);
    }

    @Override
    public void update(Character character) {
        repository.save(character);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) throw new ElementNotFoundException(id, "character");
        repository.deleteMovieCharacterEntries(id);
        repository.deleteById(id);
    }
}
