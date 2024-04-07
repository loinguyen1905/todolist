package com.loinguyen1905.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loinguyen1905.todo.entities.User;
import com.loinguyen1905.todo.services.UserService;
import com.loinguyen1905.todo.util.models.ApiResponse;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService; 

    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity<ApiResponse> getAllusers() {
        return userService.getAllUser();
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("") 
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user) {
        return this.userService.createNewUser(user);
    } 

    @PatchMapping("/{id}") 
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long id, @RequestBody User user) { 
        user.setId(id);
        return this.userService.updateUser(user);
    } 
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<ApiResponse> getAllusers(@PathVariable User user) { 
        return this.userService.deleteUser(user);
    }
}