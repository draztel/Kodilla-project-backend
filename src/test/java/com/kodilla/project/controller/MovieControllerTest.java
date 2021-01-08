package com.kodilla.project.controller;

import com.google.gson.Gson;
import com.kodilla.project.domain.Movie;
import com.kodilla.project.domain.dto.MovieDto;
import com.kodilla.project.mapper.MovieMapper;
import com.kodilla.project.service.MovieDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
@RunWith(SpringRunner.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieDbService service;

    @MockBean
    private MovieMapper mapper;

    @Test
    public void shouldGetAllMovies() throws Exception {
        //Given
        List<MovieDto> movieDtoList = new ArrayList<>();
        final MovieDto movieDto1 = new MovieDto(1l, "name", "description", "author");
        final MovieDto movieDto2 = new MovieDto(1l, "name", "description", "author");
        movieDtoList.add(movieDto1);
        movieDtoList.add(movieDto2);

        List<Movie> movieList = new ArrayList<>();
        final Movie movie1 = new Movie(1l, "name", "description", "author");
        final Movie movie2 = new Movie(1l, "name", "description", "author");
        movieList.add(movie1);
        movieList.add(movie2);

        //when
        when(service.getMovies()).thenReturn(movieList);
        when(mapper.mapToMovieDtoList(movieList)).thenReturn(movieDtoList);

        //then
        mockMvc.perform(get("/v1/movie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    public void shouldGetMoviesByName() throws Exception {
        //given
        List<MovieDto> movieDtoList = new ArrayList<>();
        final MovieDto movieDto1 = new MovieDto(1l, "name", "description", "author");
        final MovieDto movieDto2 = new MovieDto(1l, "name", "description", "author");
        movieDtoList.add(movieDto1);
        movieDtoList.add(movieDto2);

        List<Movie> movieList = new ArrayList<>();
        final Movie movie1 = new Movie(1l, "name", "description", "author");
        final Movie movie2 = new Movie(1l, "name", "description", "author");
        movieList.add(movie1);
        movieList.add(movie2);

        //when
        when(service.getMoviesByName(anyString())).thenReturn(movieList);
        when(mapper.mapToMovieDtoList(movieList)).thenReturn(movieDtoList);

        //then
        mockMvc.perform(get("/v1/movie/name/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    public void shouldGetMovieById() throws Exception {
        //Given
        final MovieDto movieDto = new MovieDto(1l, "name", "description", "author");
        final Movie movie = new Movie(1l, "name", "description", "author");

        //when
        when(service.getMovie(anyLong())).thenReturn(Optional.of(movie));
        when(mapper.mapToMovieDto(movie)).thenReturn(movieDto);

        //then
        mockMvc.perform(get("/v1/movie/id/1")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.description", is("description")))
                .andExpect(jsonPath("$.author", is("author")));
    }

    @Test
    public void shouldDeleteMovie() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/movie/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateMovie() throws Exception {
        //given
        MovieDto movieDto = new MovieDto(1l, "name", "description", "author");
        Movie movie = new Movie(1l, "name", "description", "author");

        //when
        when(mapper.mapToMovie(movieDto)).thenReturn(movie);
        when(service.saveMovie(movie)).thenReturn(movie);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(movieDto);

        //then
        mockMvc.perform(post("/v1/movie")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateOffer() throws Exception {
        //given
        MovieDto movieDto = new MovieDto(1l, "name", "description", "author");
        Movie movie = new Movie(1l, "name", "description", "author");

        //when
        when(mapper.mapToMovie(movieDto)).thenReturn(movie);
        when(service.saveMovie(movie)).thenReturn(movie);
        when(mapper.mapToMovieDto(movie)).thenReturn(movieDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(movieDto);

        //then
        mockMvc.perform(put("/v1/movie")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(status().isOk());
    }
}
