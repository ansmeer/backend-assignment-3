package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Character;
import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetCharactersDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetDTO;
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
    @Mapping(target = "franchise", source = "franchise.id")
    MovieGetDTO movieToMovieGetDto(Movie movie);

    List<MovieGetDTO> movieToMovieGetDto(List<Movie> movies);

    @Mapping(target = "characters", qualifiedByName = "charactersToCharacterIds")
    MovieGetCharactersDTO movieToMovieGetCharactersDto(Movie movie);

    @Named(value = "charactersToCharacterIds")
    default Set<Integer> map(Set<Character> value) {
        if (value == null) {
            return null;
        }
        return value.stream().map(Character::getId).collect(Collectors.toSet());
    }

    Movie moviePostDtoToMovie(MoviePostDTO movie);

    Movie moviePutDtoToMovie(MoviePutDTO movie);
}
