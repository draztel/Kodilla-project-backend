package com.kodilla.project.controller;

import com.google.gson.Gson;
import com.kodilla.project.domain.User;
import com.kodilla.project.domain.dto.UserDto;
import com.kodilla.project.mapper.UserMapper;
import com.kodilla.project.service.UserDbService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDbService service;

    @MockBean
    private UserMapper mapper;

    @Test
    public void shouldGetAllUsers() throws Exception {
        //given
        List<UserDto> userDtoList = new ArrayList<>();
        final UserDto userDto1 = new UserDto(1l, "firstname", "lastname");
        final UserDto userDto2 = new UserDto(1l, "firstname", "lastname");
        userDtoList.add(userDto1);
        userDtoList.add(userDto2);

        List<User> userList = new ArrayList<>();
        final User user1 = new User(1l, "firstname", "lastname");
        final User user2 = new User(1l, "firstname", "lastname");
        userList.add(user1);
        userList.add(user2);

        when(service.getUsers()).thenReturn(userList);
        when(mapper.mapToUserDtoList(userList)).thenReturn(userDtoList);

        //when & then
        mockMvc.perform(get("/v1/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    public void shouldGetUser() throws Exception {
        //given
        final UserDto userDto = new UserDto(1l, "firstname", "lastname");
        final User user = new User(1l, "firstname", "lastname");

        when(service.getUser(anyLong())).thenReturn(Optional.of(user));
        when(mapper.mapToUserDto(user)).thenReturn(userDto);

        //then & when
        mockMvc.perform(get("/v1/users/getById/1")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstname", is("firstname")))
                .andExpect(jsonPath("$.lastname", is("lastname")));
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateUser() throws Exception {
        //given
        final UserDto userDto = new UserDto(1l, "firstname", "lastname");
        final User user = new User(1l, "firstname", "lastname");

        when(mapper.mapToUser(userDto)).thenReturn(user);
        when(service.saveUser(user)).thenReturn(user);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //when & then
        mockMvc.perform(post("/v1/users")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        //given
        final UserDto userDto = new UserDto(1l, "firstname", "lastname");
        final User user = new User(1l, "firstname", "lastname");

        when(mapper.mapToUser(userDto)).thenReturn(user);
        when(service.saveUser(user)).thenReturn(user);
        when(mapper.mapToUserDto(user)).thenReturn(userDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //when & then
        mockMvc.perform(post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
