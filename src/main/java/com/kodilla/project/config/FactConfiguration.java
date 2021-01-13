package com.kodilla.project.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FactConfiguration {

    @Value("${fact.api.endpoint}")
    private String factApiEndpoint;

    @Value("${fact.api.key}")
    private String factApiKey;
}
