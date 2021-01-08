package com.kodilla.project.mapper;

import com.kodilla.project.domain.Movie;
import com.kodilla.project.domain.dto.MovieDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MovieMapperTest {

    @InjectMocks
    private MovieMapper mapper;

    @Test
    public void shouldMapToMovie() {
        //given
        MovieDto movieDto = new MovieDto(1l, "name", "description", "author");
        Long testId = movieDto.getId();

        //when
        Movie movie = mapper.mapToMovie(movieDto);

        //then
        Assert.assertEquals(testId, movie.getId());
        Assert.assertEquals("name", movie.getName());
        Assert.assertEquals("description", movie.getDescription());
        Assert.assertEquals("author", movie.getAuthor());
    }

    @Test
    public void shouldMapToMovieDto() {
        //given
        Movie movie = new Movie(1l, "name", "description", "author");
        Long testId = movie.getId();

        //when
        MovieDto movieDto = mapper.mapToMovieDto(movie);

        //then
        Assert.assertEquals(testId, movieDto.getId());
        Assert.assertEquals("name", movieDto.getName());
        Assert.assertEquals("description", movieDto.getDescription());
        Assert.assertEquals("author", movieDto.getAuthor());
    }

    @Test
    public void shouldMapToMovieList() {
        //given
        List<MovieDto> movieDtoList = new ArrayList<>();
        movieDtoList.add(new MovieDto(1l, "name", "description", "author"));
        movieDtoList.add(new MovieDto(1l, "name", "description", "author"));

        //when
        List<Movie> movieList = mapper.mapToMovieList(movieDtoList);

        //then
        Assert.assertEquals(2, movieList.size());
    }

    @Test
    public void shouldMapToMovieDtoList() {
        //given
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1l, "name", "description", "author"));
        movieList.add(new Movie(1l, "name", "description", "author"));

        //when
        List<MovieDto> movieDtoList = mapper.mapToMovieDtoList(movieList);

        //then
        Assert.assertEquals(2, movieDtoList.size());
    }
}
