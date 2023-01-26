package com.ansmeer.backendassignment3.services;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).orElseThrow();
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public Character update(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public int deleteById(Integer id) {
        if (characterRepository.existsById(id)) {
            characterRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(Character character) {
        return deleteById(character.getId());
    }
}
