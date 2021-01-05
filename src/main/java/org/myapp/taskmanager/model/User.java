package org.myapp.taskmanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<TaskTime> taskTimes;
    @OneToMany(mappedBy = "owner")
    private List<Task> ownerTasks;
    @OneToMany(mappedBy = "executor")
    private List<Task> executorTasks;
    @ManyToMany
    @JoinTable(name = "user_to_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<TaskTime> getTaskTimes() {
        return taskTimes;
    }

    public void setTaskTimes(List<TaskTime> taskTimes) {
        this.taskTimes = taskTimes;
    }

    public List<Task> getOwnerTasks() {
        return ownerTasks;
    }

    public void setOwnerTasks(List<Task> ownerTasks) {
        this.ownerTasks = ownerTasks;
    }

    public List<Task> getExecutorTasks() {
        return executorTasks;
    }

    public void setExecutorTasks(List<Task> executorTasks) {
        this.executorTasks = executorTasks;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public enum Role {
        admin, manager, executor;
    }
}
