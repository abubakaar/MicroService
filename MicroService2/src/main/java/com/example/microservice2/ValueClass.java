package com.example.microservice2;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController("/")
public class ValueClass {

    @GetMapping("")
    public int ReturnValue() {
        Random rand = new Random();
        int value =  rand.nextInt(10 - 1) + 1;
        System.out.println("this is the Instance Called with value "+value );
        return value;
    }
}
