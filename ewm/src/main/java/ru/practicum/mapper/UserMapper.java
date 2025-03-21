package ru.practicum.mapper;

import ru.practicum.dto.UserDto;
import ru.practicum.dto.UserShortDto;
import ru.practicum.dto.UserWithFollowersDto;
import ru.practicum.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        return user;
    }

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDto> toUserDtos(List<User> users) {
        List<UserDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(toUserDto(user));
        }
        return dtos;
    }

    public static UserShortDto toUserShortDto(User user) {
        return new UserShortDto(user.getId(), user.getName());
    }

    public static UserWithFollowersDto toDtoWithFollowees(User user) {
        return UserWithFollowersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .followers(toUserDtos(user.getFollowees()))
                .build();
    }
}
