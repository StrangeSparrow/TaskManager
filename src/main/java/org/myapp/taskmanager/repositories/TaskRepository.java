package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByOwnerIdLike(int id);

    List<Task> findByExecutorIdLike(int id);

    List<Task> findByProjectIdLike(int id);
}
