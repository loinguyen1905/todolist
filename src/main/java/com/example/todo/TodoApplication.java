package com.example.todo;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.models.User;
import com.example.todo.repositories.UserRepository;

@SpringBootApplication
public class TodoApplication {
	public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TodoApplication.class);
        application.setEnvironmentPrefix("prefix");
        SpringApplication.run(TodoApplication.class, args);
    }
}
