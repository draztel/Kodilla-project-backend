package com.kodilla.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;

    public UserDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
