package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.model.TaskTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTimeRepository extends JpaRepository<TaskTime, Integer> {
}
