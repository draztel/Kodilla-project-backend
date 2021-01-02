package com.kodilla.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private Long id;
    private String name;
    private String description;
    private double price;

    public OfferDto(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
