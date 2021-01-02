package com.kodilla.project.domain.dto;

import com.kodilla.project.domain.Offer;
import com.kodilla.project.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    private Long id;
    private String name;
    private String description;
    private double price;

    public GameDto(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
