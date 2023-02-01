package com.ansmeer.backendassignment3.services.movie;

import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.services.CrudService;

public interface MovieService extends CrudService<Movie, Integer> {
    void updateFranchise(int movieId, int franchiseId);

    void updateCharacters(int movieId, int[] characters);
}
