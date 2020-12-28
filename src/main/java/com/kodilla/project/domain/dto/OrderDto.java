package com.kodilla.project.domain.dto;

import com.kodilla.project.domain.Offer;
import com.kodilla.project.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Date from;
    private Date to;
    private User user;
    private Offer offer;
}
