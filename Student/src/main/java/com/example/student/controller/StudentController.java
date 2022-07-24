package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.DefaultValue;
import java.util.Collections;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo repository;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/student")
    public Student getByClassLevel(@DefaultValue("0") @RequestParam("classLevel") int classLevel, @DefaultValue("0") @RequestParam("id") int id) {

        if (classLevel != 0) {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.ALL));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            int class_id = restTemplate.exchange("http://localhost:8002/class/" + classLevel, HttpMethod.GET, entity, Integer.class).getBody();
            Student s =  repository.findByLevel(class_id).orElse(null);
            return s;
        } else if (id != 0)
            return repository.findById(id).orElse(null);
        else
            return null;
    }

    @GetMapping("")
    public void addstd(){
        repository.save(new Student(11,"Asad","small",1));
    }
}
