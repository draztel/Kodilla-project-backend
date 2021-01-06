package com.kodilla.project.client;

import com.kodilla.project.config.FactConfiguration;
import com.kodilla.project.domain.dto.FactDto;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class FactClient {

    @Autowired
    private FactConfiguration configuration;

    public FactDto getRandomFact() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://all-random.p.rapidapi.com/fact")
                .get()
                .addHeader("x-rapidapi-key", configuration.getFactApiKey())
                .addHeader("x-rapidapi-host", configuration.getFactApiEndpoint())
                .build();

        FactDto factDto = new FactDto();
        factDto.setFact(client.newCall(request).execute().body().string());
        factDto.setFact(factDto.getFact().substring(9, factDto.getFact().length() - 2));
        return factDto;
    }
}
