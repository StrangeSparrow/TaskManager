package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "SELECT * FROM task_manager_db.task t WHERE t.owner_id = ?1 OR t.executor_id = ?1", nativeQuery = true)
    List<Task> findTasksByUserId(int id);
}
