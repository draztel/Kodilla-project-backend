package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return new UserDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {

    }

}
