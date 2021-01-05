package com.kodilla.project.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JokeConfiguration {

    @Value("${joke.api.endpoint}")
    private String jokeApiEndpoint;
}
