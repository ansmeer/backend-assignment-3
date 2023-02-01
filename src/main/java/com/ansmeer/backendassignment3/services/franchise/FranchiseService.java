package com.ansmeer.backendassignment3.services.franchise;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.services.CrudService;

import java.util.List;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    void updateMovies(int franchiseId, int[] movies);

    List<Character> getCharacters(int id);
}
