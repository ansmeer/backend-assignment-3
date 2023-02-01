package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetSummaryDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePostDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    /**
     * Converts a Movie entity into a MovieGetDTO.
     *
     * @param movie the Movie entity
     * @return the MovieGetDTO
     */
    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", qualifiedByName = "charactersToCharacterIds")
    MovieGetDTO movieToMovieGetDto(Movie movie);

    /**
     * Converts a set of Character entities into a set of their ids.
     *
     * @param characters the set of Character entities
     * @return the set of character ids
     */
    @Named(value = "charactersToCharacterIds")
    default Set<Integer> charactersToCharacterIds(Set<Character> characters) {
        if (characters == null) {
            return null;
        }
        return characters.stream().map(Character::getId).collect(Collectors.toSet());
    }

    /**
     * Converts a list of Movie entities into a list of MovieGetDTOs.
     *
     * @param movies the list of Movie entities
     * @return the list of MovieGetDTOs
     */
    List<MovieGetDTO> movieToMovieGetDto(List<Movie> movies);

    /**
     * Converts a set of Movie entities into a set of MovieGetSummaryDTOs.
     *
     * @param movie the set of Movie entities
     * @return the set of MovieGetSummaryDTOs
     */
    Set<MovieGetSummaryDTO> movieToMovieGetSummaryDto(Set<Movie> movie);

    /**
     * Converts a MoviePostDTO into a Movie entity.
     *
     * @param movie the MoviePostDTO
     * @return the Movie entity
     */
    Movie moviePostDtoToMovie(MoviePostDTO movie);

    /**
     * Converts a MoviePutDTO into a Movie entity.
     *
     * @param movie the MoviePutDTO
     * @return the Movie entity
     */
    Movie moviePutDtoToMovie(MoviePutDTO movie);
}
