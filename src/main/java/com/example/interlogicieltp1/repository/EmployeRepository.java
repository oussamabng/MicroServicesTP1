package com.example.interlogicieltp1.repository;

import com.example.interlogicieltp1.entites.Department;
import com.example.interlogicieltp1.entites.Employe;
import com.example.interlogicieltp1.entites.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    public Collection<Employe> findEmployeByEmployeEmailEndingWith(String domaine);

    public List<Employe> findEmployesByDepartment(Department department);

    @Query("SELECT count(e) FROM Employe e WHERE e.employeGender=:gender ")
    public Integer nbEmployeByGender(@Param("gender") Genre gender);

    @Query("SELECT e.employeId ,e.project.projectName FROM Employe e WHERE e.department.departmentName=:departmentName")
    public Object[] employeByDepartment(@Param("departmentName") String departmentName);

}
