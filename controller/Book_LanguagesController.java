package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Book_Languages;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.Book_LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
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

    @GetMapping("/{id}")
    public Book_Languages bookLanguagesById(@PathVariable(value = "id") long bookLanguage){
        return this.book_languagesRepository.findById(bookLanguage)
                .orElseThrow(()-> new ResourceNotFoundException("BookLanguages with this Id NOT FOUND!" + bookLanguage));

    }
    @PostMapping
    public Book_Languages bookLanguages(@RequestBody Book_Languages bookLanguages){
        return this.book_languagesRepository.save(bookLanguages);
    }
    @PutMapping("/{id}")
    public  Book_Languages updatebookLanguages(@RequestBody Book_Languages bookLanguages, @PathVariable(value = "id") long bookLanguageId){
        Book_Languages existingBookLanguage = this.book_languagesRepository.findById(bookLanguageId)
                .orElseThrow(()-> new ResourceNotFoundException("BookLanguage with this Id NOT FOUND!" + bookLanguageId));
        existingBookLanguage.setBook(existingBookLanguage.getBook());
        existingBookLanguage.setLanguages(existingBookLanguage.getLanguages());
        return this.book_languagesRepository.save(existingBookLanguage);
    }
}
