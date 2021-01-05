package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(int id);
}
