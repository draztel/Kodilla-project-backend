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
@RequestMapping("/v1/movie")
public class MovieController {
    @Autowired
    private MovieDbService service;

    @Autowired
    private MovieMapper movieMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<MovieDto> getMovies() {
        return movieMapper.mapToMovieDtoList(service.getMovies());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{movieName}")
    public List<MovieDto> getMoviesByName(@PathVariable String movieName) {
        return movieMapper.mapToMovieDtoList(service.getMoviesByName(movieName));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{movieId}")
    public MovieDto getMovie(@PathVariable Long movieId) throws NotFoundException {
        return movieMapper.mapToMovieDto(service.getMovie(movieId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{movieId}")
    public void deleteMovie(@PathVariable Long movieId) {
        service.deleteMovie(movieId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        return movieMapper.mapToMovieDto(service.saveMovie(movieMapper.mapToMovie(movieDto)));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createMovie(@RequestBody MovieDto movieDto) {
        service.saveMovie(movieMapper.mapToMovie(movieDto));
    }
}
