package com.SpringProject.SpringBootProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Languages")
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long languages_id;
    @NotBlank
    @Size(min = 2, max = 30, message = "Language name should contain minimum 2 and maximum 30 characters !")
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "languages")
    private Set<Books> books = new HashSet<>();
    public Languages(){

    }

    public Languages(String name, Set<Books> books) {
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
