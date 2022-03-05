package com.example.interlogicieltp1.controller;

import com.example.interlogicieltp1.entites.*;
import com.example.interlogicieltp1.repository.DepartmentRepository;
import com.example.interlogicieltp1.repository.EmployeRepository;
import com.example.interlogicieltp1.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@Slf4j
@RequestMapping("/rsu")
public class ClientController {
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @GetMapping("/departement/employe-projet")
    public Object[] getEmployeByDepartment(@RequestParam("dn") String dn){
        return employeRepository.employeByDepartment(dn);
    }

    @PostMapping("/employe")
    public Employe insertEmployeByDepartment(@RequestParam("iddepart") Long iddepart, @RequestBody Map<String,Object> payload){
        Department department = departmentRepository.findById(iddepart).get();
        Employe employe = new Employe();

        employe.setEmployeName(payload.get("employeName").toString());
        employe.setEmployeGender(Genre.valueOf(payload.get("employeGender").toString()));
        employe.setEmployeDate(new Date());
        employe.setEmployeEmail(payload.get("employeEmail").toString());
        employe.setAddresses(null);
        employe.setDepartment(department);
        employe.setProject(null);

        return employeRepository.save(employe);
    }

    @PostMapping("employe2")
    public Employe createEmploye2(@RequestBody Map<String,Object>payload){
        Employe e = new Employe();
        e.setEmployeId(null);
        e.setEmployeName(payload.get("employeName").toString());
        e.setEmployeEmail(payload.get("employeEmail").toString());
        e.setEmployeGender(Genre.valueOf(payload.get("employeGender").toString()));
        e.setEmployeDate(new Date());
        e.setAddresses(null);
        e.setProject(null);
        e.setDepartment(departmentRepository.findById(Long.valueOf(payload.get("department").toString())).get());
        return employeRepository.save(e);
    };

    @PutMapping("/employe/{id}")
    public Employe modifyEmploye(@PathVariable("id") Long idEmploye , @RequestBody Employe employe){
        if(employeRepository.findById(idEmploye).isPresent()){
            employe.setEmployeId((idEmploye));
            return employeRepository.save(employe);
        }
        return null;
    };

    @PatchMapping("/employe/{id}")
    public Employe modifyEmploye2(@PathVariable("id") Long idEmploye , @RequestBody Map<String,Object> payload){
        Employe employe = new Employe();
        Employe emp = employeRepository.findById(idEmploye).get();
        if (employeRepository.findById(idEmploye).isPresent()){
            employe.setEmployeId(idEmploye);
            if (payload.get("employeName") != null){
                employe.setEmployeName(payload.get("employeName").toString());
            } else employe.setEmployeName(emp.getEmployeName());

            if (payload.get("employeGender") != null){
                employe.setEmployeGender(Genre.valueOf(payload.get("employeGender").toString()));
            } else employe.setEmployeGender(emp.getEmployeGender());

            if (payload.get("employeDate") != null){
                employe.setEmployeDate((Date) payload.get("employeDate"));
            } else employe.setEmployeDate(emp.getEmployeDate());

            if (payload.get("employeEmail") != null){
                employe.setEmployeEmail(payload.get("employeEmail").toString());
            } else employe.setEmployeEmail(emp.getEmployeEmail());

            if (payload.get("addresses") != null){
                employe.setAddresses((Collection<Address>) payload.get("addresses"));
            } else employe.setAddresses(emp.getAddresses());

            if (payload.get("department") != null){
                employe.setDepartment(departmentRepository.findById(Long.valueOf(payload.get("department").toString())).get());
            } else employe.setDepartment(emp.getDepartment());
            if (payload.get("project") != null){
                employe.setProject(projectRepository.findById(Long.valueOf(payload.get("project").toString())).get());
            } else employe.setProject(emp.getProject());
            return employeRepository.save(employe);
        }
        return null;
    }

    @PutMapping("/projet/{idprojet}/{idemp}")
    public Employe addEmployeByProject(@PathVariable("idprojet") Long idprojet,@PathVariable("idemp") Long idemp){
        if (employeRepository.findById(idemp).isPresent() && projectRepository.findById(idprojet).isPresent()){
            Project project = projectRepository.findById(idprojet).get();
            Employe employe = employeRepository.findById(idemp).get();
            employe.setProject(project);
            return employeRepository.save(employe);
        }
        return null;
    }

    @DeleteMapping("/projet/{idprojet}/{idemp}")
    public Employe removeEmployeByProject(@PathVariable("idprojet") Long idprojet,@PathVariable("idemp") Long idemp){
        if (employeRepository.findById(idemp).isPresent() && projectRepository.findById(idprojet).isPresent()){
            Project project = projectRepository.findById(idprojet).get();
            Employe employe = employeRepository.findById(idemp).get();
            if (employe.getProject() == project){
                employe.setProject(null);
                return employeRepository.save(employe);
            }
        }
        return null;
    }

}
