package com.ansmeer.backendassignment3.services.movie;

import com.ansmeer.backendassignment3.exceptions.ElementNotFoundException;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.repositories.FranchiseRepository;
import com.ansmeer.backendassignment3.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;
    private final FranchiseRepository franchiseRepository;

    public MovieServiceImpl(MovieRepository repository, FranchiseRepository franchiseRepository) {
        this.repository = repository;
        this.franchiseRepository = franchiseRepository;
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
    public Movie update(Movie movie) {
        return repository.save(movie);
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
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public int updateFranchise(int movieId, int franchiseId) {
        if (!repository.existsById(movieId)) throw new ElementNotFoundException(movieId, "movie");
        if (!franchiseRepository.existsById(franchiseId)) throw new ElementNotFoundException(franchiseId, "franchise");
        return repository.updateFranchise(movieId, franchiseId);
    }
}
