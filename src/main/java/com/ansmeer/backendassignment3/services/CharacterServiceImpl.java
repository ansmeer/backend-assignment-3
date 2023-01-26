package com.ansmeer.backendassignment3.services;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Override
    public Character findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Character> findAll() {
        return null;
    }

    @Override
    public Character add(Character entity) {
        return null;
    }

    @Override
    public Character update(Character entity) {
        return null;
    }

    @Override
    public int deleteById(Integer integer) {
        return 0;
    }

    @Override
    public int delete(Character entity) {
        return 0;
    }
}
