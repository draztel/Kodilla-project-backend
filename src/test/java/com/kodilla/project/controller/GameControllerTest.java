package com.kodilla.project.controller;

import com.google.gson.Gson;
import com.kodilla.project.domain.Game;
import com.kodilla.project.domain.dto.GameDto;
import com.kodilla.project.mapper.GameMapper;
import com.kodilla.project.service.GameDbService;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
@RunWith(SpringRunner.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameDbService service;

    @MockBean
    private GameMapper mapper;

    @Test
    public void shouldGetAllGames() throws Exception {
        //Given
        List<GameDto> gameDtoList = new ArrayList<>();
        final GameDto gameDto1 = new GameDto(1l, "name", "description", 100.00);
        final GameDto gameDto2 = new GameDto(1l, "name", "description", 100.00);
        gameDtoList.add(gameDto1);
        gameDtoList.add(gameDto2);

        List<Game> gameList = new ArrayList<>();
        final Game game1 = new Game(1l, "name", "description", 100.00);
        final Game game2 = new Game(1l, "name", "description", 100.00);
        gameList.add(game1);
        gameList.add(game2);

        when(service.getGames()).thenReturn(gameList);
        when(mapper.mapToGameDtoList(gameList)).thenReturn(gameDtoList);

        //when & then
        mockMvc.perform(get("/v1/game"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    public void shouldGetGamesByName() throws Exception {
        //Given
        List<GameDto> gameDtoList = new ArrayList<>();
        final GameDto gameDto1 = new GameDto(1l, "name", "description", 100.00);
        final GameDto gameDto2 = new GameDto(1l, "name", "description", 100.00);
        gameDtoList.add(gameDto1);
        gameDtoList.add(gameDto2);

        List<Game> gameList = new ArrayList<>();
        final Game game1 = new Game(1l, "name", "description", 100.00);
        final Game game2 = new Game(1l, "name", "description", 100.00);
        gameList.add(game1);
        gameList.add(game2);

        //when
        when(service.getGamesByName(anyString())).thenReturn(gameList);
        when(mapper.mapToGameDtoList(gameList)).thenReturn(gameDtoList);

        //then
        mockMvc.perform(get("/v1/game/name/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    public void shouldGetGame() throws Exception {
        //given
        final GameDto gameDto = new GameDto(1l, "name", "description", 100.00);
        final Game game = new Game(1l, "name", "description", 100.00);

        when(service.getGame(anyLong())).thenReturn(Optional.of(game));
        when(mapper.mapToGameDto(game)).thenReturn(gameDto);

        //when & then
        mockMvc.perform(get("/v1/game/id/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.description", is("description")))
                .andExpect(jsonPath("$.price", is(100.00)));
    }

    @Test
    public void shouldDeleteGame() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/game/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateGame() throws Exception {
        //given
        final Game game = new Game(1l, "name", "description", 100.00);
        final GameDto gameDto = new GameDto(1l, "name", "description", 100.00);

        when(mapper.mapToGame(gameDto)).thenReturn(game);
        when(service.saveGame(game)).thenReturn(game);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(gameDto);

        //then & when
        mockMvc.perform(post("/v1/game")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateGame() throws Exception {
        //given
        Game game = new Game(1l, "name", "description", 100.00);
        GameDto gameDto = new GameDto(1l, "name", "description", 100.00);

        when(mapper.mapToGame(gameDto)).thenReturn(game);
        when(service.saveGame(game)).thenReturn(game);
        when(mapper.mapToGameDto(game)).thenReturn(gameDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(gameDto);

        //then & when
        mockMvc.perform(put("/v1/game")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
