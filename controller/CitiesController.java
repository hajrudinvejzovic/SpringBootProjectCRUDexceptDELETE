package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Cities;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    @Autowired
    private CitiesRepository citiesRepository;
    @GetMapping
    public List<Cities> allCities(){
        return this.citiesRepository.findAll();
    }
    @GetMapping("/{id}")
    public Cities cityById(@PathVariable(value = "id") long cityId){
        return this.citiesRepository.findById(cityId)
                .orElseThrow(()-> new ResourceNotFoundException("City with this Id NOT FOUND!" + cityId));
    }
    @PostMapping
    public Cities city(@RequestBody Cities city){
        return this.citiesRepository.save(city);
    }

    @PutMapping("/{id}")
    public Cities updateCity(@RequestBody Cities city, @PathVariable(value = "id") long cityId){
        Cities existingCity = this.citiesRepository.findById(cityId)
                .orElseThrow(()-> new ResourceNotFoundException("City with this Id NOT FOUND!" + cityId));
        existingCity.setName(existingCity.getName());
        existingCity.setAuthor(existingCity.getAuthor());
        existingCity.setEmployee(existingCity.getEmployee());
        existingCity.setUser(existingCity.getUser());
       return this.citiesRepository.save(existingCity);
    }
}
