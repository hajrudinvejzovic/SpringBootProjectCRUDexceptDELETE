package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Book_Genres;
import com.SpringProject.SpringBootProject.repository.Book_GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book_genres")
public class Book_GenresController {
   @Autowired
    private Book_GenresRepository book_genresRepository;

   @GetMapping
    public List<Book_Genres> allBookGenres(){
       return this.book_genresRepository.findAll();
   }

}
