package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Reports;
import com.SpringProject.SpringBootProject.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
    @Autowired
    private ReportsRepository reportsRepository;
    @GetMapping("/api/reports")
    public List<Reports> allReports(){
        return this.reportsRepository.findAll();
    }
}
