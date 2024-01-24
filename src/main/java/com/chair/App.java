package com.chair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class App {
    public static void main(String[] args) {
        System.out.println("Starting Spring Boot Application...");
        SpringApplication.run(App.class, args);
        System.out.println("Spring Boot Application has Started...");
    }
}