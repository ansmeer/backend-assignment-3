package com.ansmeer.backendassignment3.services;

import com.ansmeer.backendassignment3.models.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService {
    @Override
    public Movie findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        return null;
    }

    @Override
    public Movie add(Movie entity) {
        return null;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    public int deleteById(Integer integer) {
        return 0;
    }

    @Override
    public int delete(Movie entity) {
        return 0;
    }
}
