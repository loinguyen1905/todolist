package com.loinguyen1905.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class TodoApplication {
	public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TodoApplication.class);
        application.setEnvironmentPrefix("prefix");
        SpringApplication.run(TodoApplication.class, args);
    }
}