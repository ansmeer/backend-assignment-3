package com.ansmeer.backendassignment3.services.character;

import com.ansmeer.backendassignment3.exceptions.ElementNotFoundException;
import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.repositories.CharacterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean existsById(int id) {
        return repository.existsById(id);
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
    public Character update(Character character) {
        return repository.save(character);
    }

    @Transactional
    @Override
    public int deleteById(Integer id) {
        if (!repository.existsById(id)) {
            return 0;
        }
        repository.deleteMovieCharacterEntries(id);
        repository.deleteById(id);
        return 1;
    }

    @Override
    public int delete(Character character) {
        return deleteById(character.getId());
    }
}
