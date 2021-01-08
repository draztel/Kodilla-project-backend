package com.kodilla.project.controller;

import com.kodilla.project.client.JokeClient;
import com.kodilla.project.domain.dto.JokeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/joke")
public class JokeController {

    @Autowired
    private JokeClient jokeClient;

    @RequestMapping(method = RequestMethod.GET, value = "/random")
    public JokeDto getJoke() {
        return jokeClient.getRandomJoke();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/random_ten")
    public List<JokeDto> getTenJokes() {
        return jokeClient.getRandomTenJokes();
    }
}
