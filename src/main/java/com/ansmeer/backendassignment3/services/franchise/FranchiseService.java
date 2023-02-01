package com.ansmeer.backendassignment3.services.franchise;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.services.CrudService;

import java.util.List;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    /**
     * Links one or more Movie entities to a franchise by its id.
     *
     * @param franchiseId the franchise's id
     * @param movies      array of movie ids
     */
    void updateMovies(int franchiseId, int[] movies);

    /**
     * Returns a list of Character entities that are linked to a franchise by its id.
     *
     * @param id the franchise's id
     * @return the list of Character entities
     */
    List<Character> getCharacters(int id);
}
