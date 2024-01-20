package com.chair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Starting Spring Boot Application...");
        SpringApplication.run(App.class, args);
        System.out.println("Spring Boot Application has Started...");
    }
}