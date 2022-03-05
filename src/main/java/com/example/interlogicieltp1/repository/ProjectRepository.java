package com.example.interlogicieltp1.repository;

import com.example.interlogicieltp1.entites.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
