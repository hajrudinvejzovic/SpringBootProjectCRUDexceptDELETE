package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Book_Authors;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.Book_AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public Book_Authors bookAuthorsById(@PathVariable(value = "id") long bookAuthorId){
        return this.book_authorsRepository.findById(bookAuthorId)
                .orElseThrow(()-> new ResourceNotFoundException("Book_Author with this Id NOT FOUND!" + bookAuthorId));
    }
    @PostMapping
    public Book_Authors bookAuthors(@RequestBody Book_Authors bookAuthors){
        return this.book_authorsRepository.save(bookAuthors);
    }
    @PutMapping("/{id}")
    public Book_Authors updateBookAuthors(@RequestBody Book_Authors bookAuthors, @PathVariable(value ="id") long bookAuthorsId){
        Book_Authors existingBookAuthors = this.book_authorsRepository.findById(bookAuthorsId)
                .orElseThrow(()-> new ResourceNotFoundException("BookAuthors with this Id NOT FOUND!"));
        existingBookAuthors.setAuthor(existingBookAuthors.getAuthor());
        existingBookAuthors.setBook(existingBookAuthors.getBook());
        return this.book_authorsRepository.save(existingBookAuthors);
    }

}
