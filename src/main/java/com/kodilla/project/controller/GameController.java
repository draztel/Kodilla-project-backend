package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.GameDto;
import com.kodilla.project.exception.NotFoundException;
import com.kodilla.project.mapper.GameMapper;
import com.kodilla.project.service.GameDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/game")
public class GameController {

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private GameDbService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<GameDto> getGames() {
        return gameMapper.mapToGameDtoList(service.getGames());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{gameName}")
    public List<GameDto> getGamesByName(@PathVariable String gameName) {
        return gameMapper.mapToGameDtoList(service.getGamesByName(gameName));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{gameId}")
    public GameDto getGame(@PathVariable Long gameId) throws NotFoundException {
        return gameMapper.mapToGameDto(service.getGame(gameId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{gameId}")
    public void deleteGame(@PathVariable Long gameId) {
        service.deleteGame(gameId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public GameDto updateGame(@RequestBody GameDto gameDto) {
        return gameMapper.mapToGameDto(service.saveGame(gameMapper.mapToGame(gameDto)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createGame(@RequestBody GameDto gameDto) {
        service.saveGame(gameMapper.mapToGame(gameDto));
    }
}
