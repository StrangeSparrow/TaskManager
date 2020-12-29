package org.myapp.taskmanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;
    @ManyToOne
    @JoinColumn(name = "task_status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToMany(mappedBy = "task")
    private List<TaskTime> taskTimes;
}
