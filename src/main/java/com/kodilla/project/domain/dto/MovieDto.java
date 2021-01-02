package com.kodilla.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String name;
    private String description;
    private String author;

    public MovieDto(String name, String description, String author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }
}
