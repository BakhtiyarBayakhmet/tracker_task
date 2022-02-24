package com.task.tracker.controller;

import com.task.tracker.model.Task;
import com.task.tracker.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskResource {
    private final TaskService service;

    
    public TaskResource(TaskService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTaskList() {
        List<Task> result = service.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        Task result = service.getById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task entity) {
        Task result = service.create(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task entity = service.getById(id);
        entity.setName(taskDetails.getName());
        entity.setDescription(taskDetails.getDescription());

        Task result = service.update(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Task entity = service.getById(id);
        service.deleteById(id);
        return ResponseEntity.ok("Task with ID " + id + " is successfully deleted");
    }
}
