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

    @GetMapping("/by-task/{id}/executor")
    public UserDto getExecutorByTaskId(@PathVariable("id") int id) {
        UserDto users = userService.getUsersByExecutorTaskId(id);

        return users;
    }

    @GetMapping("/by-task/{id}/owner")
    public UserDto getOwnerByTaskId(@PathVariable("id") int id) {
        UserDto users = userService.getUsersByOwnerTaskId(id);

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

    @GetMapping("/owners")
    public List<UserDto> getOwners() {
        return userService.getOwners();
    }

    @GetMapping("/executors")
    public List<UserDto> getExecutors() {
        return userService.getExecutors();
    }
}
