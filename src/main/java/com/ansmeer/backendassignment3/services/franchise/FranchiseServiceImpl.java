package com.ansmeer.backendassignment3.services.franchise;

import com.ansmeer.backendassignment3.exceptions.ElementNotFoundException;
import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.repositories.FranchiseRepository;
import com.ansmeer.backendassignment3.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository repository;
    private final MovieRepository movieRepository;

    public FranchiseServiceImpl(FranchiseRepository repository, MovieRepository movieRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
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
        if (!repository.existsById(id)) {
            return 0;
        }
        movieRepository.findByFranchiseId(id).forEach(movie -> {
            movie.setFranchise(null);
            movieRepository.save(movie);
        });
        repository.deleteById(id);
        return 1;
    }

    @Override
    public int delete(Franchise franchise) {
        return deleteById(franchise.getId());
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}
