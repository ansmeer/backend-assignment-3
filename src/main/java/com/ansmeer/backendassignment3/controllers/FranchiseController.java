package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.mappers.FranchiseMapper;
import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetMoviesDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePostDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePutDTO;
import com.ansmeer.backendassignment3.services.franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranchiseGetDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                franchiseMapper.franchiseToFranchiseGetDto(
                        franchiseService.findById(id)
                ));
    }

    @GetMapping
    public ResponseEntity<List<FranchiseGetDTO>> getAll() {
        return ResponseEntity.ok(
                franchiseMapper.franchiseToFranchiseGetDto(
                        franchiseService.findAll()
                ));
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<FranchiseGetMoviesDTO> getMovies(@PathVariable int id) {
        return ResponseEntity.ok(
                franchiseMapper.franchiseToFranchiseGetMoviesDto(
                        franchiseService.findById(id)
                )
        );
    }

    @GetMapping("/{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id) {
        // TODO
        return null;
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody FranchisePostDTO franchise) {
        Franchise newFranchise = franchiseService.add(
                franchiseMapper.franchisePostDtoToFranchise(franchise));
        URI uri = URI.create("api/v1/franchises/" + newFranchise.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody FranchisePutDTO franchise, @PathVariable int id) {
        if (franchise.getId() != id)
            return ResponseEntity.badRequest().build();
        franchiseService.update(
                franchiseMapper.franchisePutDtoToFranchise(franchise));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/movies")
    public ResponseEntity<Object> updateMovies(@PathVariable int id, @RequestBody int[] movies) {
        franchiseService.updateMovies(id, movies);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
