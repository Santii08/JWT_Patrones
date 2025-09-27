package com.example.jwtapi.ejemploclase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.jwtapi")
public class JwtApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtApiApplication.class, args);
    }
}