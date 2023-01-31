package com.ansmeer.backendassignment3.services.franchise;

import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.services.CrudService;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    boolean existsById(int id);

    void updateMovies(int franchiseId, int[] movies);
}
