package com.ansmeer.backendassignment3.repositories;

import com.ansmeer.backendassignment3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Modifying
    @Query(value = "delete from movie_character where character_id = ?1", nativeQuery = true)
    void deleteMovieCharacterEntries(int id);

    @Query(value = "SELECT character.* " +
            "FROM (SELECT movie_character.character_id " +
            "FROM movie " +
            "INNER JOIN movie_character ON movie.id=movie_character.movie_id " +
            "WHERE movie.franchise_id=?1) AS mc " +
            "INNER JOIN character ON mc.character_id=character.id " +
            "GROUP BY character.id " +
            "ORDER BY character.id ASC",
            nativeQuery = true)
    List<Character> findByFranchiseId(int id);
}
