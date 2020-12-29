package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.model.User;
import org.myapp.taskmanager.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepositories userRepositories;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userRepositories.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        Optional<User> user = userRepositories.findById(1);
        return user.get();
    }
}
