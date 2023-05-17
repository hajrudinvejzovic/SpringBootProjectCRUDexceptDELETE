package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Contacts;
import com.SpringProject.SpringBootProject.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {
    @Autowired
    private ContactsRepository contactsRepository;

    @GetMapping
    public List<Contacts> allContacts(){
        return this.contactsRepository.findAll();
    }
}
