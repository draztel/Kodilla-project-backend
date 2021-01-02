package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.MovieDto;
import com.kodilla.project.exception.NotFoundException;
import com.kodilla.project.mapper.MovieMapper;
import com.kodilla.project.service.MovieDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class MovieController {
    @Autowired
    private MovieDbService service;

    @Autowired
    private MovieMapper movieMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public List<MovieDto> getMovies() {
        return movieMapper.mapToMovieDtoList(service.getMovies());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/getByName/{movieName}")
    public List<MovieDto> getMoviesByName(@PathVariable String movieName) {
        return movieMapper.mapToMovieDtoList(service.getMoviesByName(movieName));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/getById/{movieId}")
    public MovieDto getMovie(@PathVariable Long movieId) throws NotFoundException {
        return movieMapper.mapToMovieDto(service.getMovie(movieId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{movieId}")
    public void deleteMovie(@PathVariable Long movieId) {
        service.deleteMovie(movieId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies")
    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        return movieMapper.mapToMovieDto(service.saveMovie(movieMapper.mapToMovie(movieDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/movies", consumes = APPLICATION_JSON_VALUE)
    public void createMovie(@RequestBody MovieDto movieDto) {
        service.saveMovie(movieMapper.mapToMovie(movieDto));
    }
}
