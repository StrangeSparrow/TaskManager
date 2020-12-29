package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.model.User;
import org.myapp.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userService.getAll();
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        User user = userService.getById(id);
        return user;
    }
}
