package com.kodilla.project.service;

import com.kodilla.project.domain.Movie;
import com.kodilla.project.repository.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieDbService {
    @Autowired
    private MovieDao movieDao;

    public List<Movie> getMovies() {
        return movieDao.findAll();
    }

    public List<Movie> getMoviesByName(String name) {
        return movieDao.findByName(name);
    }

    public Optional<Movie> getMovie(final Long id) {
        return movieDao.findById(id);
    }

    public Movie saveMovie(final Movie movie) {
        return movieDao.save(movie);
    }

    public void deleteMovie(final Long id) {
        movieDao.deleteById(id);
    }
}
