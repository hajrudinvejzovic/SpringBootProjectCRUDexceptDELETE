package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Languages;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    @Autowired
    private LanguagesRepository languagesRepository;

    @GetMapping
    public List<Languages> allLanguages(){
        return this.languagesRepository.findAll();
    }
    @GetMapping("/{id}")
    public Languages languageById(@PathVariable(value = "id") long languageId){
        return this.languagesRepository.findById(languageId)
                .orElseThrow(()-> new ResourceNotFoundException("Language with this Id NOT FOUND!" + languageId));
    }
    @PostMapping
    public Languages language(@RequestBody Languages language){
        return this.languagesRepository.save(language);
    }

    @PutMapping("/{id}")
    public Languages updateLanugage(@RequestBody Languages language, @PathVariable (value = "id") long languageId ){
        Languages existingLanguage = this.languagesRepository.findById(languageId)
                .orElseThrow(()-> new ResourceNotFoundException("Language with this Id NOT FOUND" + languageId));
        existingLanguage.setName(existingLanguage.getName());
        existingLanguage.setBook_Languages(existingLanguage.getBook_Languages());
        return this.languagesRepository.save(existingLanguage);
    }
}
