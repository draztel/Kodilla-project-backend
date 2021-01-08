package com.kodilla.project.mapper;

import com.kodilla.project.domain.Game;
import com.kodilla.project.domain.dto.GameDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GameMapperTest {

    @InjectMocks
    private GameMapper mapper;

    @Test
    public void shouldMapToGame() {
        //given
        GameDto gameDto = new GameDto(1l, "name", "description", 100.00);
        Long testId = gameDto.getId();

        //when
        Game game = mapper.mapToGame(gameDto);

        //Then
        Assert.assertEquals(testId, game.getId());
        Assert.assertEquals("name", game.getName());
        Assert.assertEquals("description", game.getDescription());
        Assert.assertEquals(100.00, game.getPrice(), 0.01);
    }

    @Test
    public void shouldMapToGameDto() {
        //given
        Game game = new Game(1l, "name", "description", 100.00);
        Long testId = game.getId();

        //when
        GameDto gameDto = mapper.mapToGameDto(game);

        //Then
        Assert.assertEquals(testId, gameDto.getId());
        Assert.assertEquals("name", gameDto.getName());
        Assert.assertEquals("description", gameDto.getDescription());
        Assert.assertEquals(100.00, gameDto.getPrice(), 0.01);
    }

    @Test
    public void shouldMapToGameList() {
        //given
        List<GameDto> gameDtoList = new ArrayList<>();
        gameDtoList.add(new GameDto(1l, "name", "description", 100.00));
        gameDtoList.add(new GameDto(1l, "name", "description", 100.00));

        //when
        List<Game> gameList = mapper.mapToGameList(gameDtoList);

        //then
        Assert.assertEquals(2, gameList.size());
    }

    @Test
    public void shouldMapToGameDtoList() {
        //given
        List<Game> gameList = new ArrayList<>();
        gameList.add(new Game(1l, "name", "description", 100.00));
        gameList.add(new Game(1l, "name", "description", 100.00));

        //when
        List<GameDto> gameDtoList = mapper.mapToGameDtoList(gameList);

        //then
        Assert.assertEquals(2, gameDtoList.size());
    }
}
