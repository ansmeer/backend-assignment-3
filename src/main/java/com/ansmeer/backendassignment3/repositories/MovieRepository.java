package com.ansmeer.backendassignment3.repositories;

import com.ansmeer.backendassignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByFranchiseId(int id);

    boolean existsById(int id);
}
