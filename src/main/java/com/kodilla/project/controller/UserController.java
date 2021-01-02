package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.UserDto;
import com.kodilla.project.exception.NotFoundException;
import com.kodilla.project.mapper.UserMapper;
import com.kodilla.project.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDbService service;


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(service.getUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userFirstname}")
    public List<UserDto> getUsersByFirstname(@PathVariable String userFirstname) {
        return userMapper.mapToUserDtoList(service.getUsersByFirstname(userFirstname));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws NotFoundException {
       return userMapper.mapToUserDto(service.getUser(userId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        service.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(service.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }

}
