package com.task.tracker.repository;

import com.task.tracker.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//It helps to get requests
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
