package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetDTO;
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
    /**
     * Converts a Franchise entity into a FranchiseGetDTO.
     *
     * @param franchise the Franchise entity
     * @return the FranchiseGetDTO
     */
    @Mapping(target = "movies", qualifiedByName = "moviesToMovieIds")
    FranchiseGetDTO franchiseToFranchiseGetDto(Franchise franchise);

    /**
     * Converts a set of Movie entities into a set of their ids.
     *
     * @param movies the set of Movie entities
     * @return the set of movie ids
     */
    @Named(value = "moviesToMovieIds")
    default Set<Integer> moviesToMovieIds(Set<Movie> movies) {
        if (movies == null) {
            return null;
        }
        return movies.stream().map(Movie::getId).collect(Collectors.toSet());
    }

    /**
     * Converts a list of Franchise entities to a list of FranchiseGetDTOs.
     *
     * @param franchise the Franchise entity
     * @return the list of FranchiseGetDTOs
     */
    List<FranchiseGetDTO> franchiseToFranchiseGetDto(List<Franchise> franchise);

    /**
     * Converts a FranchisePostDTO to a Franchise entity.
     *
     * @param franchise the FranchisePostDTO
     * @return the Franchise entity
     */
    Franchise franchisePostDtoToFranchise(FranchisePostDTO franchise);

    /**
     * Converts a FranchisePutDTO to a Franchise entity.
     *
     * @param franchise the FranchisePutDTO
     * @return the Franchise entity
     */
    Franchise franchisePutDtoToFranchise(FranchisePutDTO franchise);
}