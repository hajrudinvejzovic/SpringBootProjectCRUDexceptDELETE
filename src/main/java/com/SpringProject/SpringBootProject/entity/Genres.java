package com.SpringProject.SpringBootProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long genres_id;
    @NotBlank
    @Size(min = 3, max = 30, message = "genres must contain minimum 3 and maximum 30 characters!")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<Book_Genres> BookGenres = new HashSet<>();
    public Genres(){

    }

    public Genres(String name, Set<Book_Genres> bookGenres) {
        this.name = name;
        BookGenres = bookGenres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book_Genres> getBookGenres() {
        return BookGenres;
    }

    public void setBookGenres(Set<Book_Genres> bookGenres) {
        BookGenres = bookGenres;
    }
}
