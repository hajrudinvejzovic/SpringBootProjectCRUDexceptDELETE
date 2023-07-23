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

    @ManyToMany(mappedBy = "genres")
    private Set<Books> books = new HashSet<>();
    public Genres(){

    }

    public Genres(String name, Set<Books> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}
