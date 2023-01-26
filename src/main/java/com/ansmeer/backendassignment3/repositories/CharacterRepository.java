package com.ansmeer.backendassignment3.repositories;

import com.ansmeer.backendassignment3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
