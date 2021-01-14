package org.myapp.taskmanager.repositories;

import org.myapp.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Project findByTasksIdLike(int id);
}
