package org.myapp.taskmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "task_time")
public class TaskTime {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
