package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Authors;
import com.SpringProject.SpringBootProject.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
    @Autowired
    private AuthorsRepository authorsRepository;

    //GET ALL
    @GetMapping
    public List<Authors> allAuthors(){
        return this.authorsRepository.findAll();
    }

}
