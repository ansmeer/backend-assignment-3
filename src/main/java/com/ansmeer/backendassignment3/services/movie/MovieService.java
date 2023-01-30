package com.ansmeer.backendassignment3.services.movie;

import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.services.CrudService;

public interface MovieService extends CrudService<Movie, Integer> {
    boolean existsById(int id);

    int updateFranchise(int movieId, int franchiseId);
}
