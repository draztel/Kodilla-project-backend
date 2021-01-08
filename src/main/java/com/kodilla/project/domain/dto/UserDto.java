package com.kodilla.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
}
