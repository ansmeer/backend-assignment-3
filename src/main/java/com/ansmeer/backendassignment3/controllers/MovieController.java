package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.mappers.CharacterMapper;
import com.ansmeer.backendassignment3.mappers.MovieMapper;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetSummaryDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePostDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePutDTO;
import com.ansmeer.backendassignment3.services.movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

/**
 * Handles all api requests related to movies
 * under the base uri "api/v1/movies".
 */
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final CharacterMapper characterMapper;

    public MovieController(MovieService movieService,
                           MovieMapper movieMapper,
                           CharacterMapper characterMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.characterMapper = characterMapper;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a movie by its id", tags = {"Movie", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MovieGetDTO.class))),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
    })
    public ResponseEntity<MovieGetDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.movieToMovieGetDto(
                        movieService.findById(id)
                ));
    }

    @GetMapping
    @Operation(summary = "Get all movies", tags = {"Movie", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = MovieGetDTO.class))))
    })
    public ResponseEntity<List<MovieGetDTO>> getAll() {
        return ResponseEntity.ok(
                movieMapper.movieToMovieGetDto(
                        movieService.findAll())
        );
    }

    @GetMapping("/{id}/characters")
    @Operation(summary = "Get all characters in a movie", tags = {"Movie", "Character", "Get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CharacterGetSummaryDTO.class)))
            ),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
    })
    public ResponseEntity<Set<CharacterGetSummaryDTO>> getCharacters(@PathVariable int id) {
        return ResponseEntity.ok(
                characterMapper.characterToCharacterGetSummaryDto(
                        movieService.findById(id).getCharacters()
                ));
    }

    @PostMapping
    @Operation(summary = "Add a movie", tags = {"Movie", "Post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content)
    })
    public ResponseEntity<Object> add(@RequestBody MoviePostDTO movie) throws URISyntaxException {
        Movie newMovie = movieService.add(
                movieMapper.moviePostDtoToMovie(movie));
        URI uri = new URI("api/v1/movies/" + newMovie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a movie", tags = {"Movie", "Put"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request, URI does not match request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
    })
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
    @Operation(summary = "Update a movie's characters", tags = {"Movie", "Character", "Put"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Characters updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie or character(s) not found", content = @Content),
    })
    public ResponseEntity<Object> updateCharacters(@PathVariable int id, @RequestBody int[] characters) {
        movieService.updateCharacters(id, characters);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/franchise")
    @Operation(summary = "Update a movie's franchise", tags = {"Movie", "Franchise", "Put"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie or franchise not found", content = @Content),
    })
    public ResponseEntity<Object> updateFranchise(@PathVariable int id, @RequestBody int franchise) {
        movieService.updateFranchise(id, franchise);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a movie by its id", tags = {"Movie", "Delete"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
    })
    public ResponseEntity<Object> delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
