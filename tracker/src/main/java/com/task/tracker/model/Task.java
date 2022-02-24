package com.task.tracker.model;

import com.task.tracker.model.enums.TaskStatus;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Lob
    @Column(name = "description")
    @Type(type = "org.hibernate.type.TextType")
    private String description;
    private Integer priority;
    @ManyToOne
    @JoinColumn(name="project_id", nullable = false)
    private Project project;
}
