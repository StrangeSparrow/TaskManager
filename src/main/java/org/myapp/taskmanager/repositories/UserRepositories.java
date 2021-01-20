package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
    Optional<User> findByOwnerTasksIdLike(int id);

    Optional<User> findByExecutorTasksIdLike(int id);

    List<User> findByRole(User.Role role);
}
