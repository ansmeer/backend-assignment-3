package com.ansmeer.backendassignment3.services.franchise;

import com.ansmeer.backendassignment3.exceptions.ElementNotFoundException;
import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.repositories.CharacterRepository;
import com.ansmeer.backendassignment3.repositories.FranchiseRepository;
import com.ansmeer.backendassignment3.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class describes an implementation of the franchise service interface
 * and interacts with different repositories.
 */
@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository repository;
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    public FranchiseServiceImpl(FranchiseRepository repository,
                                MovieRepository movieRepository,
                                CharacterRepository characterRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
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
    public void update(Franchise franchise) {
        repository.save(franchise);
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) throw new ElementNotFoundException(id, "franchise");

        movieRepository.findByFranchiseId(id).forEach(movie -> {
            movie.setFranchise(null);
            movieRepository.save(movie);
        });
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateMovies(int franchiseId, int[] movies) {
        if (!repository.existsById(franchiseId)) throw new ElementNotFoundException(franchiseId, "franchise");
        for (int movie : movies) {
            if (!movieRepository.existsById(movie)) throw new ElementNotFoundException(movie, "movie");
            movieRepository.updateFranchise(movie, franchiseId);
        }
    }

    @Override
    public List<Character> getCharacters(int id) {
        if (!repository.existsById(id)) throw new ElementNotFoundException(id, "franchise");
        return characterRepository.findByFranchiseId(id);
    }
}
