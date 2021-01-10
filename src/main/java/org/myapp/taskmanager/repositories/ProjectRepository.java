package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "SELECT * FROM task_manager_db.project p JOIN task_manager_db.task t ON t.project_id = p.id WHERE t.id = ?1",
            nativeQuery = true)
    Project findProjectsByTaskId(int id);
}
