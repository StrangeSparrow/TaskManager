package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(int id);

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    void deleteUserById(int id);

    UserDto getUsersByOwnerTaskId(int id);

    UserDto getUsersByExecutorTaskId(int id);

    List<UserDto> getOwners();

    List<UserDto> getExecutors();
}

