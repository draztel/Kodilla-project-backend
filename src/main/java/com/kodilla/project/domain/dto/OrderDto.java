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
public class OrderDto {
    private Long id;
    private LocalDate from;
    private LocalDate to;
    private User user;
    private Offer offer;
}
