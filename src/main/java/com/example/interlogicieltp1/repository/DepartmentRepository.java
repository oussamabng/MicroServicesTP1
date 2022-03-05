package com.example.interlogicieltp1.repository;

import com.example.interlogicieltp1.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department getDepartmentByDepartmentName(String name);
}
