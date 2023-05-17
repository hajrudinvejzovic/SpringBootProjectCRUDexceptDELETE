package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Book_Languages;
import com.SpringProject.SpringBootProject.repository.Book_LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book_languages")
public class Book_LanguagesController {
    @Autowired
    private Book_LanguagesRepository book_languagesRepository;
    @GetMapping
    public List<Book_Languages> allLanguages(){
        return this.book_languagesRepository.findAll();
    }
}
