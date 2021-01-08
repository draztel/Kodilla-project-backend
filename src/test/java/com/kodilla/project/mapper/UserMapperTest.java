package com.kodilla.project.mapper;

import com.kodilla.project.domain.Game;
import com.kodilla.project.domain.User;
import com.kodilla.project.domain.dto.GameDto;
import com.kodilla.project.domain.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    @InjectMocks
    private UserMapper mapper;

    @Test
    public void shouldMapToUser() {
        //given
        UserDto userDto = new UserDto(1l, "firstname", "lastname");
        Long testId = userDto.getId();

        //when
        User user = mapper.mapToUser(userDto);

        //Then
        Assert.assertEquals(testId, user.getId());
        Assert.assertEquals("firstname", user.getFirstname());
        Assert.assertEquals("lastname", user.getLastname());
    }

    @Test
    public void shouldMapToUserDto() {
        //given
        User user = new User(1l, "firstname", "lastname");
        Long testId = user.getId();

        //when
        UserDto userDto = mapper.mapToUserDto(user);

        //Then
        Assert.assertEquals(testId, userDto.getId());
        Assert.assertEquals("firstname", userDto.getFirstname());
        Assert.assertEquals("lastname", userDto.getLastname());
    }

    @Test
    public void shouldMapToUserList() {
        //given
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto(1l, "firstname", "lastname"));
        userDtoList.add(new UserDto(1l, "firstname", "lastname"));

        //when
        List<User> userList = mapper.mapToUserList(userDtoList);

        //then
        Assert.assertEquals(2, userList.size());
    }

    @Test
    public void shouldMapToUserDtoList() {
        //given
        List<User> userList = new ArrayList<>();
        userList.add(new User(1l, "firstname", "lastname"));
        userList.add(new User(1l, "firstname", "lastname"));

        //when
        List<UserDto> userDtoList = mapper.mapToUserDtoList(userList);

        //then
        Assert.assertEquals(2, userDtoList.size());
    }
}
