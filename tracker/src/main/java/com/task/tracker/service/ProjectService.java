package com.task.tracker.service;

import com.task.tracker.exception.ResourceNotFoundException;
import com.task.tracker.model.Project;
import com.task.tracker.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    public List<Project> getAll() {
        List<Project> entities = repo.findAll();
        return entities;
    }

    public Project getById(Long id) throws ResourceNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project with ID " + id + " does not exist"));
    }

    public Project create(Project entity) {
        return repo.saveAndFlush(entity);
    }

    public Project update(Project entity) {
        return repo.saveAndFlush(entity);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
