package com.ansmeer.backendassignment3.repositories;

import com.ansmeer.backendassignment3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Modifying
    @Query(value = "delete from movie_character where character_id = ?1", nativeQuery = true)
    void deleteMovieCharacterEntries(int id);

}
