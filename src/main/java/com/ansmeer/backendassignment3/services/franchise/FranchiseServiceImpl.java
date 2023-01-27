package com.ansmeer.backendassignment3.services.franchise;

import com.ansmeer.backendassignment3.exceptions.ElementNotFoundException;
import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.repositories.FranchiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository repository;

    public FranchiseServiceImpl(FranchiseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Franchise findById(Integer id) {
        return repository.findById(id).orElseThrow(()
                -> new ElementNotFoundException(id, "franchise"));
    }

    @Override
    public List<Franchise> findAll() {
        return repository.findAll();
    }

    @Override
    public Franchise add(Franchise franchise) {
        return repository.save(franchise);
    }

    @Override
    public Franchise update(Franchise franchise) {
        return repository.save(franchise);
    }

    @Override
    public int deleteById(Integer id) {
        //TODO: set franchise_id to null for movies
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(Franchise franchise) {
        return deleteById(franchise.getId());
    }
}
