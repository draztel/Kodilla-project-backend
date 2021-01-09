package com.kodilla.project.controller;

import com.kodilla.project.client.JokeClient;
import com.kodilla.project.domain.dto.JokeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JokeController.class)
@RunWith(SpringRunner.class)
public class JokeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JokeClient client;

    @Test
    public void shouldGetRandomJoke() throws Exception {
        //given
        JokeDto jokeDto = new JokeDto("id", "type", "setup", "punchline");

        //when
        when(client.getRandomJoke()).thenReturn(jokeDto);

        //then
        mockMvc.perform(get("/v1/joke/random"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetTenRandomJokes() throws Exception {
        //given
        List<JokeDto> jokeDtoList = new ArrayList<>();
        JokeDto jokeDto1 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto2 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto3 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto4 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto5 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto6 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto7 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto8 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto9 = new JokeDto("id", "type", "setup", "punchline");
        JokeDto jokeDto10 = new JokeDto("id", "type", "setup", "punchline");
        jokeDtoList.add(jokeDto1);
        jokeDtoList.add(jokeDto2);
        jokeDtoList.add(jokeDto3);
        jokeDtoList.add(jokeDto4);
        jokeDtoList.add(jokeDto5);
        jokeDtoList.add(jokeDto6);
        jokeDtoList.add(jokeDto7);
        jokeDtoList.add(jokeDto8);
        jokeDtoList.add(jokeDto9);
        jokeDtoList.add(jokeDto10);

        //when
        when(client.getRandomTenJokes()).thenReturn(jokeDtoList);

        //then
        mockMvc.perform(get("/v1/joke/random_ten"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(10)));
    }
}
