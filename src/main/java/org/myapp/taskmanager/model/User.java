package org.myapp.taskmanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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

    public enum Role {
        admin, manager, executor;
    }
}
