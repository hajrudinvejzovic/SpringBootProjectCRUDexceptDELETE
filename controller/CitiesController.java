package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Cities;
import com.SpringProject.SpringBootProject.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    @Autowired
    private CitiesRepository citiesRepository;

    public List<Cities> allCities(){
        return this.citiesRepository.findAll();
    }
}
