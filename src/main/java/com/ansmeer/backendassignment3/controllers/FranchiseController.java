package com.ansmeer.backendassignment3.controllers;

import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.services.franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok((franchiseService.findById(id)));
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Franchise franchise) {
        Franchise newFranchise = franchiseService.add(franchise);
        URI uri = URI.create("franchises/" + newFranchise.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Franchise franchise, @PathVariable int id) {
        if (franchise.getId() != id)
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchise);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (!franchiseService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
