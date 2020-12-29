package org.myapp.taskmanager.service;

import org.myapp.taskmanager.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(int id);
}
