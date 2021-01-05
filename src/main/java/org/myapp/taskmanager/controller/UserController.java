package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userService.getAll();
        return users;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) {
        UserDto user = userService.getById(id);
        return user;
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
    }
}
