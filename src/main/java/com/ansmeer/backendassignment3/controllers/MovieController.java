package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.mappers.MovieMapper;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetCharactersDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePostDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePutDTO;
import com.ansmeer.backendassignment3.services.movie.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public ResponseEntity<List<MovieGetDTO>> getAll() {
        return ResponseEntity.ok(
                movieMapper.movieToMovieGetDto(
                        movieService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieGetDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.movieToMovieGetDto(
                        movieService.findById(id)
                ));
    }

    @GetMapping("/{id}/characters")
    public ResponseEntity<MovieGetCharactersDTO> getCharacters(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.movieToMovieGetCharactersDto(
                        movieService.findById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody MoviePostDTO movie) throws URISyntaxException {
        Movie newMovie = movieService.add(
                movieMapper.moviePostDtoToMovie(movie));
        URI uri = new URI("api/v1/movies/" + newMovie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody MoviePutDTO movie) {
        if (id != movie.getId()) {
            return ResponseEntity.badRequest().build();
        }
        movieService.update(
                movieMapper.moviePutDtoToMovie(movie)
        );
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/characters")
    public ResponseEntity updateCharacters(@PathVariable int id, @RequestBody int[] characters) {
        // TODO fix with DTOs
        return null;
    }

    @PutMapping("/{id}/franchise")
    public ResponseEntity<Object> updateFranchise(@PathVariable int id, @RequestBody int franchise) {
        movieService.updateFranchise(id, franchise);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
