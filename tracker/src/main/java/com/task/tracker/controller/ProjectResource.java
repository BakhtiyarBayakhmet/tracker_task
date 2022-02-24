package com.task.tracker.controller;

import com.task.tracker.exception.ResourceNotFoundException;
import com.task.tracker.model.Project;
import com.task.tracker.model.Task;
import com.task.tracker.service.ProjectService;
import com.task.tracker.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectResource {
    private final ProjectService service;
    private final TaskService taskService;

    public ProjectResource(ProjectService service, TaskService taskService) {
        this.service = service;
        this.taskService = taskService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProjectList() {
        List<Project> result = service.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProject(@PathVariable Long id) throws ResourceNotFoundException {
        Project result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
        public ResponseEntity<?> createProject(@RequestBody Project entity) {
        Project result = service.create(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editProject(@PathVariable Long id, @RequestBody Project details) throws ResourceNotFoundException {
        Project entity = service.getById(id);
        if (entity == null) {
            return null;
        }
        entity.setName(details.getName());
        Project result = service.update(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}/tasks")
    public ResponseEntity<?> createTaskForProject(@PathVariable Long id, @RequestBody Task taskDetails) throws ResourceNotFoundException {
        taskService.create(taskDetails);
        Project result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}/tasks/{taskId}")
    public ResponseEntity<?> deleteTaskOfProject(@PathVariable Long id, @PathVariable Long taskId) throws ResourceNotFoundException {
        taskService.deleteById(taskId);
        Project result = service.getById(id);
        return ResponseEntity.ok(result);
    }
}
