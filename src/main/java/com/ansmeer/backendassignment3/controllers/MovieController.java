package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.services.movie.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping("/{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok(movie.getCharacters());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Movie movie) throws URISyntaxException {
        Movie newMovie = movieService.add(movie);
        URI uri = new URI("api/v1/movies/" + newMovie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Movie movie) {
        if (id != movie.getId()) {
            return ResponseEntity.badRequest().build();
        }
        movieService.update(movie);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/characters")
    public ResponseEntity updateCharacters(@PathVariable int id, @RequestBody int[] characters) {
        // TODO fix with DTOs
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (!movieService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
