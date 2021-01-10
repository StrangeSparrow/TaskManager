package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userService.getAll();
        return users;
    }

    @GetMapping("/by_task/{id}")
    public List<UserDto> getUsersByTaskId(@PathVariable("id") int id) {
        List<UserDto> users = userService.getUsersByTaskId(id);

        return users;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) {
        UserDto user = userService.getById(id);
        return user;
    }

    @PostMapping
    public void addUser(@RequestBody UserDto userDto) {
        userService.add(userDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
    }
}
