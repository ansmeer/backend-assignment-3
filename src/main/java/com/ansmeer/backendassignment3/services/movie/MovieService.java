package com.ansmeer.backendassignment3.services.movie;

import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.services.CrudService;

public interface MovieService extends CrudService<Movie, Integer> {
    /**
     * Links a movie to a franchise.
     *
     * @param movieId     the id of the movie
     * @param franchiseId the id of the franchise
     */
    void updateFranchise(int movieId, int franchiseId);

    /**
     * Links a movie to one or more characters.
     *
     * @param movieId    the id of the movie
     * @param characters the ids of the characters
     */
    void updateCharacters(int movieId, int[] characters);
}
