package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Movie;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MovieGetSummaryDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePostDTO;
import com.ansmeer.backendassignment3.models.dtos.movie.MoviePutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "franchise", source = "franchise.id")
    MovieGetDTO movieToMovieGetDto(Movie movie);

    List<MovieGetDTO> movieToMovieGetDto(List<Movie> movies);

    Set<MovieGetSummaryDTO> movieToMovieGetSummaryDto(Set<Movie> movie);

    Movie moviePostDtoToMovie(MoviePostDTO movie);

    Movie moviePutDtoToMovie(MoviePutDTO movie);
}
