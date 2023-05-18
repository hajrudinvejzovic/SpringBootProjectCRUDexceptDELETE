package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Book_Authors;
import com.SpringProject.SpringBootProject.entity.Book_Genres;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.Book_GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   @GetMapping("/{id}")
    public Book_Genres bookGenresById(@PathVariable(value = "id") long bookGenres){
       return this.book_genresRepository.findById(bookGenres)
               .orElseThrow(()-> new ResourceNotFoundException("Book genres by this Id NOT FOUND!" + bookGenres));
   }
   @PostMapping
    public Book_Genres bookGenres(@RequestBody Book_Genres bookGenres){
       return this.book_genresRepository.save(bookGenres);
   }
   @PutMapping("/{id}")
    public Book_Genres updateBookGenres(@RequestBody Book_Genres bookGenres, @PathVariable(value = "id") long bookGenresId){
       Book_Genres existingBookGenres = this.book_genresRepository.findById(bookGenresId)
               .orElseThrow(()-> new ResourceNotFoundException("BookGenres with this Id NOT FOUND!" + bookGenresId));
       existingBookGenres.setBook(existingBookGenres.getBook());
       existingBookGenres.setGenre(existingBookGenres.getGenre());
       return this.book_genresRepository.save(existingBookGenres);
   }

}
