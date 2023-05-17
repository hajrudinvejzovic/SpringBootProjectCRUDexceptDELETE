package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Book_Authors;
import com.SpringProject.SpringBootProject.repository.Book_AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book_authors")
public class Book_AuthorsController {
    @Autowired
    private Book_AuthorsRepository book_authorsRepository;

    //Get all
    @GetMapping
    public List<Book_Authors> book_Authors(){
        return this.book_authorsRepository.findAll();

    }

}
