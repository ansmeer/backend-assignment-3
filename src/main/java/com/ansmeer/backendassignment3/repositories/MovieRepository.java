package com.ansmeer.backendassignment3.repositories;

import com.ansmeer.backendassignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Encapsulates access to movies stored in the MovieDb.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    /**
     * Returns a list of Movie entities that belong to the same franchise by its id.
     *
     * @param id the id of the franchise
     * @return the list of Movie entities
     */
    List<Movie> findByFranchiseId(int id);

    /**
     * Updates which franchise a movie belongs to.
     *
     * @param movieId     the id of the movie to update
     * @param franchiseId the id of the franchise it belongs to
     */
    @Modifying
    @Query(value = "update movie set franchise_id=?2 where id=?1", nativeQuery = true)
    void updateFranchise(int movieId, int franchiseId);

    /**
     * Links a movie to a character.
     *
     * @param movieId     the movie id
     * @param characterId the character id
     */
    @Modifying
    @Query(value = "insert into movie_character (movie_id, character_id) values (?1, ?2) on conflict do nothing",
            nativeQuery = true)
    void addCharacterToMovie(int movieId, int characterId);

    /**
     * Unlinks a movie from a character.
     *
     * @param movieId the movie id
     */
    @Modifying
    @Query(value = "delete from movie_character where movie_id=?1", nativeQuery = true)
    void deleteAllCharactersFromMovie(int movieId);
}
