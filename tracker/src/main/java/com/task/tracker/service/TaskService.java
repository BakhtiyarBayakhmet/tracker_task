package com.task.tracker.service;

import com.task.tracker.model.Task;
import com.task.tracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        List<Task> entities = repo.findAll();
        return entities;
    }

    public Task getById(Long id) {
        return repo.findById(id).isPresent() ? repo.findById(id).get() : null;
    }

    public Task create(Task entity) {
        return repo.saveAndFlush(entity);
    }

    public Task update(Task entity) {
        return repo.saveAndFlush(entity);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
