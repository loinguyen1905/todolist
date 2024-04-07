package com.loinguyen1905.todo.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loinguyen1905.todo.entities.Task;
import com.loinguyen1905.todo.repositories.TaskRepository;
import com.loinguyen1905.todo.util.models.ApiResponse;
import com.loinguyen1905.todo.util.models.ResponseBuilder;

import jakarta.transaction.Transactional;

import java.util.List;

  
@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ResponseBuilder responseBuilder;
      
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> createNewTask(Task task) { 
        Task data = taskRepository.save(task);
        return responseBuilder.buildResponse(HttpStatus.CREATED.value(),"All tasks", data);
    } 
      
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> getAllTask() throws Exception {
        List<Task> data = taskRepository.findAll();
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All tasks", data);
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> findTaskById(Long id) {
        Task data = taskRepository.getById(id);
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All tasks", data);
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> findAllCompletedTask() { 
        List<Task> data = taskRepository.findByCompletedTrue(); 
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All tasks", data);
    } 

    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> findAllInCompleteTask() { 
        List<Task> tasks = taskRepository.findByCompletedFalse();
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All tasks", tasks);
    } 
      
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> deleteTask(Task task) { 
        taskRepository.delete(task); 
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All tasks", true);
    } 
      
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ApiResponse> updateTask(Task task) { 
        Task data = taskRepository.save(task); 
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"All tasks", data);
    } 
}