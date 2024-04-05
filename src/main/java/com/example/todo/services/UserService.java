package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.User;
import com.example.todo.repositories.UserRepository;

@Service
public class UserService { 
    @Autowired
    private UserRepository userRepository;
      
    public User createNewUser(User user) { 
        return userRepository.save(user);
    } 
      
    public List<User> getAllUser() { 
        return userRepository.findAll(); 
    }
}
