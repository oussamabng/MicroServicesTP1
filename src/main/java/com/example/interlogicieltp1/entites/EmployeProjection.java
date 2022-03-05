package com.example.interlogicieltp1.entites;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "pr1",types = Employe.class)
public interface EmployeProjection {
    public Long getEmployeId();

    @Value("#{target.project.projectName}")
    public String getProjectName();
}
