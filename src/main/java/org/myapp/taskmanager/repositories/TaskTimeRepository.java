package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.model.TaskTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskTimeRepository extends JpaRepository<TaskTime, Integer> {
    List<TaskTime> findByTaskIdLike(int id);
}
