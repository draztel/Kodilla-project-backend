package com.kodilla.project.controller;

import com.kodilla.project.client.FactClient;
import com.kodilla.project.domain.dto.FactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/fact")
public class FactController {

    @Autowired
    private FactClient client;

    @RequestMapping(method = RequestMethod.GET, value = "/random")
    public FactDto getRandomFact() throws IOException {
        return client.getRandomFact();
    }
}
