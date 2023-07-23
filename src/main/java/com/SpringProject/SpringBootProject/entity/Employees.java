package com.SpringProject.SpringBootProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employees_id;
    @NotBlank
    @Size(min = 3, max = 15, message = "Name must contain min 3 and max 15 characters!")
    @Column(name = "name")
    private String name;
    @NotBlank
    @Size(min = 3, max = 15, message = "Surname must contain min 3 and max 15 characters!")
    @Column(name = "surname")
    private String surname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private Cities city;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacts_id")
    private Contacts contact;
    public Employees(){

    }

    public Employees(String name, String surname, Cities city, Contacts contact) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }
}
