package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Genres;
import com.SpringProject.SpringBootProject.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenresController {
    @Autowired
    private GenresRepository genresRepository;
    @GetMapping
    public List<Genres> allGenres(){
        return this.genresRepository.findAll();
    }


}
