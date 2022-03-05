package com.example.interlogicieltp1;

import com.example.interlogicieltp1.entites.*;
import com.example.interlogicieltp1.repository.DepartmentRepository;
import com.example.interlogicieltp1.repository.EmployeRepository;
import com.example.interlogicieltp1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Arrays;

@SpringBootApplication
public class InterlogicielTp1Application implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(InterlogicielTp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //  add Departement
        Department department = new Department();
        department.setDepartmentName("Dep 1");
        departmentRepository.save(department);


        //  add Project
        Project project = new Project();
        project.setProjectName("Project 1");
        project.setProjectDuration(Date.valueOf("2022-01-01"));
        projectRepository.save(project);

        //  add Project
        Project project2 = new Project();
        project2.setProjectName("Project 2");
        project2.setProjectDuration(Date.valueOf("2022-01-01"));
        projectRepository.save(project2);


        //  add Employe
        Employe employe = new Employe();
        employe.setProject(project);
        employe.setEmployeName("Oussama");
        employe.setEmployeGender(Genre.Mr);
        employe.setEmployeDate(Date.valueOf("2022-01-01"));
        employe.setEmployeEmail("oussama@gmail.com");
        employe.setAddresses(Arrays.asList(
                new Address("skikda",22,"ville"),
                new Address("skikda",21,"sba")
        ));
        employe.setDepartment(department);
        employeRepository.save(employe);

        // add Employe 2
        Employe employe2 = new Employe();
        employe2.setProject(project);
        employe2.setEmployeName("Nabil");
        employe2.setEmployeGender(Genre.Mr);
        employe2.setEmployeDate(Date.valueOf("2022-01-01"));
        employe2.setEmployeEmail("nabil@esi-sba.dz");
        employe2.setAddresses(Arrays.asList(
                new Address("sba",40,"villa")
        ));
        employe2.setDepartment(department);
        employeRepository.save(employe2);

    }
}
