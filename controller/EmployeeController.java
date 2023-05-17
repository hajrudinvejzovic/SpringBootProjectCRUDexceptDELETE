package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Employees;
import com.SpringProject.SpringBootProject.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping
    public List<Employees> allEmployees(){
        return this.employeesRepository.findAll();
    }
}
