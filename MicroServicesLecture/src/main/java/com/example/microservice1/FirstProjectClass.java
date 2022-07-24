package com.example.microservice1;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/")
public class FirstProjectClass {



   @GetMapping("")
    public void printServiceData() {

        RestTemplate re = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        int value = re.exchange("http://localhost:8002/", HttpMethod.GET, entity, Integer.class).getBody();
        if (value % 2 == 0) {
            System.out.println("Even");
        } else
            System.out.println("odd");

    }
}
