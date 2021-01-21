package org.myapp.taskmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "task_time")
public class TaskTime {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "time_task")
    private int hours;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_task")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
