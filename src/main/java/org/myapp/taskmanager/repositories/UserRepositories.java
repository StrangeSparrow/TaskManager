package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
}
