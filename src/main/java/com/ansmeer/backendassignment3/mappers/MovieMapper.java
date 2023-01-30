package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "franchise", source = "franchise.id")
    MovieGetDTO movieToMovieGetDto(Movie movie);

    List<MovieGetDTO> movieToMovieGetDto(List<Movie> movies);
}
