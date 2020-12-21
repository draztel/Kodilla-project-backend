package com.kodilla.project.mapper;

import com.kodilla.project.domain.User;
import com.kodilla.project.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public List<User> mapToUserList(final List<UserDto> userDtoList) {
        return userDtoList.stream()
                .map(this::mapToUser)
                .collect(Collectors.toList());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
