package com.kodilla.project.domain.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private Long id;
    private String username;
    private String password;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto() {

    }
}
