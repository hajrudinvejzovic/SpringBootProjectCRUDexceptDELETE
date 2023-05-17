package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Languages;
import com.SpringProject.SpringBootProject.repository.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    @Autowired
    private LanguagesRepository languagesRepository;

    @GetMapping
    public List<Languages> allLanguages(){
        return this.languagesRepository.findAll();
    }
}
