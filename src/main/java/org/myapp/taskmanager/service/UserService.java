package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(int id);

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto, int id);

    void deleteUserById(int id);

    List<UserDto> getUsersByTaskId(int id);
}
