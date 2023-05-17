package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Books;
import com.SpringProject.SpringBootProject.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    @Autowired
    private BooksRepository booksRepository;

    @GetMapping
    public List<Books> allBooks(){
        return this.booksRepository.findAll();
    }
}
