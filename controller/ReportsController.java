package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Reports;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Reports reportById(@PathVariable (value = "id") long reportId){
        return this.reportsRepository.findById(reportId)
                .orElseThrow(()-> new ResourceNotFoundException("Report with this Id NOT FOUND!" + reportId));
    }
    @PostMapping
    public Reports report(@RequestBody Reports report){
        return this.reportsRepository.save(report);
    }
    @PutMapping("/{id}")
    public Reports updateReport(@RequestBody Reports report, @PathVariable (value="id") long reportId){
        Reports existingReport = this.reportsRepository.findById(reportId)
                .orElseThrow(()-> new ResourceNotFoundException("Report with this Id NOT FOUND!" + reportId));
        existingReport.setUser(existingReport.getUser());
        existingReport.setBook(existingReport.getBook());
        existingReport.setDescription(existingReport.getDescription());
        return this.reportsRepository.save(existingReport);
    }
}
