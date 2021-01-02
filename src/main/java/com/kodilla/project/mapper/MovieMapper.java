package com.kodilla.project.mapper;

import com.kodilla.project.domain.Movie;
import com.kodilla.project.domain.dto.MovieDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    public Movie mapToMovie(final MovieDto movieDto) {
        return new Movie(
                movieDto.getId(),
                movieDto.getName(),
                movieDto.getDescription(),
                movieDto.getAuthor()
        );
    }

    public MovieDto mapToMovieDto(final Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getName(),
                movie.getDescription(),
                movie.getAuthor()
        );
    }

    public List<Movie> mapToMovieList(final List<MovieDto> movieDtoList) {
        return movieDtoList.stream()
                .map(this::mapToMovie)
                .collect(Collectors.toList());
    }

    public List<MovieDto> mapToMovieDtoList(final List<Movie> movieList) {
        return movieList.stream()
                .map(this::mapToMovieDto)
                .collect(Collectors.toList());
    }
}
