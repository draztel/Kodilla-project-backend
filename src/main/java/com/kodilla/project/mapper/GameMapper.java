package com.kodilla.project.mapper;

import com.kodilla.project.domain.Game;
import com.kodilla.project.domain.dto.GameDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameMapper {

    public Game mapToGame(final GameDto gameDto) {
        return new Game(
                gameDto.getId(),
                gameDto.getName(),
                gameDto.getDescription(),
                gameDto.getPrice()
        );
    }

    public GameDto mapToGameDto(final Game game) {
        return new GameDto(
                game.getId(),
                game.getName(),
                game.getDescription(),
                game.getPrice()
        );
    }

    public List<Game> mapToGameList(final List<GameDto> gameDtoList) {
        return gameDtoList.stream()
                .map(this::mapToGame)
                .collect(Collectors.toList());
    }

    public List<GameDto> mapToGameDtoList(final List<Game> gameList) {
        return gameList.stream()
                .map(this::mapToGameDto)
                .collect(Collectors.toList());
    }
}
