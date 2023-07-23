package com.SpringProject.SpringBootProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "Contacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long contacts_id;
    @OneToOne(mappedBy = "contact")
    private User user;
    @OneToOne(mappedBy = "contact")
    private Employees employee;
    @NotNull
    @Size(min = 9, message = "number should have at least 9 numbers!")
    @Column(name = "telephone")
    private long telephone;
    @Email
    @Column(name="email")
    private String email;
    public Contacts(){

    }

    public Contacts(User user, Employees employee, long telephone, String email) {
        this.user = user;
        this.employee = employee;
        this.telephone = telephone;
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
