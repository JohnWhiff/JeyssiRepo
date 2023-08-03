package com.example.bbactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BbactivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbactivityApplication.class, args);
    }

}
