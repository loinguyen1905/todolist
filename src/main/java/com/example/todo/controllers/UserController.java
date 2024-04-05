package com.example.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.models.Task;
import com.example.todo.models.User;
import com.example.todo.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService; 
    @GetMapping("")
    public ResponseEntity<List<User>> getAllTasks() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("") 
    public ResponseEntity<User> createTask(@RequestBody User user) {
        return ResponseEntity.ok(userService.createNewUser(user)); 
    }
}