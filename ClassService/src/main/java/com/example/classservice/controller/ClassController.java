package com.example.classservice.controller;

import com.example.classservice.model.ClassModel;
import com.example.classservice.repository.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private ClassRepo repository;

    @GetMapping("/class/{level}")
    public int getById(@PathVariable("level") int level) {
        ClassModel model = repository.findByLevel(level).orElse(null);

        return model.getId();
    }


    @GetMapping("/class")
    public List<ClassModel> getAll() {
        return repository.findAll();
    }


}
