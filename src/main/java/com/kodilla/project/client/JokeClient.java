package com.kodilla.project.client;

import com.kodilla.project.config.JokeConfiguration;
import com.kodilla.project.domain.dto.JokeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import sun.net.www.http.HttpClient;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class JokeClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JokeConfiguration jokeConfiguration;

    public JokeDto getRandomJoke() {
        URI url = UriComponentsBuilder.fromHttpUrl(jokeConfiguration.getJokeApiEndpoint() + "/random_joke")
                .build().encode().toUri();

        return restTemplate.getForObject(url, JokeDto.class);
    }

    public List<JokeDto> getRandomTenJokes() {
        URI url = UriComponentsBuilder.fromHttpUrl(jokeConfiguration.getJokeApiEndpoint() + "/random_ten")
                .build().encode().toUri();

        JokeDto[] jokesResponse = restTemplate.getForObject(url, JokeDto[].class);
        return Arrays.asList(Optional.ofNullable(jokesResponse).orElse(new JokeDto[0]));
    }
}
