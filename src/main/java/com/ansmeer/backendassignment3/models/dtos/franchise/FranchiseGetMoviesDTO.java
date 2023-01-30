package com.ansmeer.backendassignment3.models.dtos.franchise;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FranchiseGetMoviesDTO {
    private int id;
    private Set<Integer> movies;
}