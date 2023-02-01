package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetMoviesDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePostDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    FranchiseGetDTO franchiseToFranchiseGetDto(Franchise franchise);

    List<FranchiseGetDTO> franchiseToFranchiseGetDto(List<Franchise> franchise);

    @Mapping(target = "movies", qualifiedByName = "moviesToMovieIds")
    FranchiseGetMoviesDTO franchiseToFranchiseGetMoviesDto(Franchise franchise);

    @Named(value = "moviesToMovieIds")
    default Set<Integer> map(Set<Movie> value) {
        if (value == null) {
            return null;
        }
        return value.stream().map(Movie::getId).collect(Collectors.toSet());
    }

    Franchise franchisePostDtoToFranchise(FranchisePostDTO franchise);

    Franchise franchisePutDtoToFranchise(FranchisePutDTO franchise);
}