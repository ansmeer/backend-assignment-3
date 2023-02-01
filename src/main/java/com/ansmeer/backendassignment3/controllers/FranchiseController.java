package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.mappers.CharacterMapper;
import com.ansmeer.backendassignment3.mappers.FranchiseMapper;
import com.ansmeer.backendassignment3.mappers.MovieMapper;
import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.models.dtos.character.CharacterGetSummaryDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePostDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePutDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetSummaryDTO;
import com.ansmeer.backendassignment3.services.franchise.FranchiseService;
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
import java.util.List;
import java.util.Set;

/**
 * Handles all api requests related to franchises
 * under the base uri "api/v1/franchises".
 */
@RestController
@RequestMapping(path = "api/v1/franchises")
public class FranchiseController {
    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;
    private final CharacterMapper characterMapper;
    private final MovieMapper movieMapper;

    public FranchiseController(FranchiseService franchiseService,
                               FranchiseMapper franchiseMapper,
                               CharacterMapper characterMapper,
                               MovieMapper movieMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
        this.characterMapper = characterMapper;
        this.movieMapper = movieMapper;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a franchise by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = FranchiseGetDTO.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Franchise not found",
                    content = @Content
            )
    })
    public ResponseEntity<FranchiseGetDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                franchiseMapper.franchiseToFranchiseGetDto(
                        franchiseService.findById(id)
                ));
    }

    @GetMapping
    @Operation(summary = "Get all franchises")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = FranchiseGetDTO.class)))
            )})
    public ResponseEntity<List<FranchiseGetDTO>> getAll() {
        return ResponseEntity.ok(
                franchiseMapper.franchiseToFranchiseGetDto(
                        franchiseService.findAll()
                ));
    }

    @GetMapping("/{id}/movies")
    @Operation(summary = "Get all movies in a franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = MovieGetSummaryDTO.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Franchise not found",
                    content = @Content
            )
    })
    public ResponseEntity<Set<MovieGetSummaryDTO>> getMovies(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.movieToMovieGetSummaryDto(
                        franchiseService.findById(id).getMovies()
                ));
    }

    @GetMapping("/{id}/characters")
    @Operation(summary = "Get all characters in a franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CharacterGetSummaryDTO.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Franchise not found",
                    content = @Content
            )
    })
    public ResponseEntity<List<CharacterGetSummaryDTO>> getCharacters(@PathVariable int id) {
        return ResponseEntity.ok(
                characterMapper.characterToCharacterGetSummaryDto(
                        franchiseService.getCharacters(id)
                ));
    }

    @PostMapping
    @Operation(summary = "Add a franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content)
    })
    public ResponseEntity<Object> add(@RequestBody FranchisePostDTO franchise) {
        Franchise newFranchise = franchiseService.add(
                franchiseMapper.franchisePostDtoToFranchise(franchise));
        URI uri = URI.create("api/v1/franchises/" + newFranchise.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Franchise updated",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request, URI does not match request body",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Franchise not found",
                    content = @Content
            ),
    })
    public ResponseEntity<Object> update(@RequestBody FranchisePutDTO franchise, @PathVariable int id) {
        if (franchise.getId() != id)
            return ResponseEntity.badRequest().build();
        franchiseService.update(
                franchiseMapper.franchisePutDtoToFranchise(franchise));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/movies")
    @Operation(summary = "Update a franchise's movies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Franchise updated",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Franchise or movie(s) not found",
                    content = @Content
            ),
    })
    public ResponseEntity<Object> updateMovies(@PathVariable int id, @RequestBody int[] movies) {
        franchiseService.updateMovies(id, movies);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a franchise by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Franchise deleted",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Franchise not found",
                    content = @Content
            ),
    })
    public ResponseEntity<Object> delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
