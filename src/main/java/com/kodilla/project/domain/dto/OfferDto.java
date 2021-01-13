package com.kodilla.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class OfferDto {
    private Long id;
    private String name;
    private String description;
    private double price;
}
