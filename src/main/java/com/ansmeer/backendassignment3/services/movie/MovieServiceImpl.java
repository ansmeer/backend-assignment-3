package com.ansmeer.backendassignment3.services.movie;

import com.ansmeer.backendassignment3.exceptions.ElementNotFoundException;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.repositories.CharacterRepository;
import com.ansmeer.backendassignment3.repositories.FranchiseRepository;
import com.ansmeer.backendassignment3.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class describes an implementation of the movie service interface
 * and interacts with different repositories.
 */
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;
    private final FranchiseRepository franchiseRepository;
    private final CharacterRepository characterRepository;

    public MovieServiceImpl(MovieRepository repository,
                            FranchiseRepository franchiseRepository,
                            CharacterRepository characterRepository) {
        this.repository = repository;
        this.franchiseRepository = franchiseRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return repository.findById(id).orElseThrow(()
                -> new ElementNotFoundException(id, "movie"));
    }

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Movie add(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public void update(Movie movie) {
        repository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) throw new ElementNotFoundException(id, "movie");
        repository.deleteById(id);
    }

    @Override
    public void delete(Movie movie) {
        deleteById(movie.getId());
    }

    @Override
    @Transactional
    public void updateFranchise(int movieId, int franchiseId) {
        if (!repository.existsById(movieId)) throw new ElementNotFoundException(movieId, "movie");
        if (!franchiseRepository.existsById(franchiseId)) throw new ElementNotFoundException(franchiseId, "franchise");
        repository.updateFranchise(movieId, franchiseId);
    }

    @Override
    @Transactional
    public void updateCharacters(int movieId, int[] characters) {
        if (!repository.existsById(movieId)) throw new ElementNotFoundException(movieId, "movie");
        repository.deleteAllCharactersFromMovie(movieId);
        for (int character : characters) {
            if (!characterRepository.existsById(character)) throw new ElementNotFoundException(character, "character");
            repository.addCharacterToMovie(movieId, character);
        }
    }
}
