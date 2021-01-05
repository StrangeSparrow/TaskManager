package org.myapp.taskmanager.service;

import org.myapp.taskmanager.converter.UserConverter;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;
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
    public void deleteUserById(int id) {
        userRepositories.deleteById(id);
    }

    private List<UserDto> convertUserList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();

        for(User user : users) {
            userDtoList.add(userConverter.convert(user));
        }

        return userDtoList;
    }
}
