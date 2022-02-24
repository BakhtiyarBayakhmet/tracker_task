package com.task.tracker.model;

import com.task.tracker.model.enums.ProjectStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "t_project")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.NotStarted;
    private Integer priority;
    @Column(updatable = false)
    private Date startDate = new Date();
    private Date completionDate;
    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Task> tasks;
}
