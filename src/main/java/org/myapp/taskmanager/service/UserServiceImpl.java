package org.myapp.taskmanager.service;

import org.myapp.taskmanager.converter.UserConverter;
import org.myapp.taskmanager.converter.UserDtoConverter;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.model.User;
import org.myapp.taskmanager.repositories.TaskRepository;
import org.myapp.taskmanager.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepositories userRepositories;
    @Autowired
    UserConverter userConverter;
    @Autowired
    UserDtoConverter dtoConverter;
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepositories.findAll();

        return convertUserList(users);
    }

    @Override
    public UserDto getById(int id) {
        Optional<User> user = userRepositories.findById(id);
        UserDto userDto = userConverter.convert(user.get());

        return userDto;
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = dtoConverter.convert(userDto);

        userRepositories.save(user);

        return userDto;
    }

    @Override
    public UserDto update(UserDto userDto, int id) {
        User user = userRepositories.findById(id).get();

        user.setName(userDto.getName());
        user.setRole(User.Role.valueOf(userDto.getRole()));

        userRepositories.flush();

        return userDto;
    }

    @Override
    public void deleteUserById(int id) {
        userRepositories.deleteById(id);
    }

    @Override
    public List<UserDto> getUsersByTaskId(int id) {
        Task task = taskRepository.findById(id).get();

        List<User> users = new ArrayList<>();

        users.add(task.getExecutor());
        users.add(task.getOwner());

        return convertUserList(users);
    }

    private List<UserDto> convertUserList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            userDtoList.add(userConverter.convert(user));
        }

        return userDtoList;
    }
}
