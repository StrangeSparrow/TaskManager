package org.myapp.taskmanager.service;

import org.myapp.taskmanager.model.User;
import org.myapp.taskmanager.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepositories repositories;

    @Override
    public List<User> getAll() {
        List<User> users = repositories.findAll();
        return users;
    }

    @Override
    public User getById(int id) {
        Optional<User> user = repositories.findById(id);
        return user.get();
    }
}
