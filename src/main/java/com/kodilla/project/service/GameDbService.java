package com.kodilla.project.service;

import com.kodilla.project.domain.Game;
import com.kodilla.project.repository.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameDbService {

    @Autowired
    private GameDao gameDao;

    public List<Game> getGames() {
        return gameDao.findAll();
    }

    public List<Game> getGamesByName(String name) {
        return gameDao.findByName(name);
    }

    public Optional<Game> getGame(final Long id) {
        return gameDao.findById(id);
    }

    public Game saveGame(final Game game) {
        return gameDao.save(game);
    }

    public void deleteGame(final Long id) {
        gameDao.deleteById(id);
    }
}
