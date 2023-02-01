package com.ansmeer.backendassignment3.repositories;

import com.ansmeer.backendassignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByFranchiseId(int id);

    @Modifying
    @Query(value = "update movie set franchise_id=?2 where id=?1", nativeQuery = true)
    void updateFranchise(int movieId, int franchiseId);

    @Modifying
    @Query(value = "insert into movie_character (movie_id, character_id) values (?1, ?2) on conflict do nothing",
            nativeQuery = true)
    void updateCharacter(int movieId, int characterId);
}
