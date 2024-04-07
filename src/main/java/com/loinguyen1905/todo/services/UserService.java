package com.loinguyen1905.todo.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loinguyen1905.todo.dto.UserDTO;
import com.loinguyen1905.todo.entities.User;
import com.loinguyen1905.todo.repositories.UserRepository;
import com.loinguyen1905.todo.util.modelmapper.MapperUtil;
import com.loinguyen1905.todo.util.models.ApiResponse;
import com.loinguyen1905.todo.util.models.ResponseBuilder;

@Service
public class UserService { 
    @Autowired
    private UserRepository userRepository;
      
    @Autowired
    private ResponseBuilder responseBuilder;

    @Autowired
    private ModelMapper modelMapper;

    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> createNewUser(User user) { 
        User data = userRepository.save(user);
        UserDTO userDTO = modelMapper.map(data, UserDTO.class);
        return responseBuilder.buildResponse(HttpStatus.CREATED.value(),"Create User", userDTO);
    } 
      
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> getAllUser() {
        List<User> data = userRepository.findAll();
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All Users", data);
    }
    
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> findUserById(Long id) {
        Optional<User> data = userRepository.findById(id);
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"Find User By Id", data);
    } 
      
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> deleteUser(User User) {
        userRepository.delete(User); 
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All Users", true);
    } 
      
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> updateUser(User User) { 
        User data = userRepository.save(User); 
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All Users", data);
    }
}
