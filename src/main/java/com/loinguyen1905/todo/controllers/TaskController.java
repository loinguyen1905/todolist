package com.loinguyen1905.todo.controllers;

import javax.naming.AuthenticationException;

import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.loinguyen1905.todo.dto.TaskDTO;
import com.loinguyen1905.todo.entities.Task;
import com.loinguyen1905.todo.exceptions.ResourceNotFoundException;
import com.loinguyen1905.todo.services.TaskService;
import com.loinguyen1905.todo.util.models.ApiResponse;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController { 

    @Autowired
    private TaskService taskService; 

    private ModelMapper modelMapper = new ModelMapper();

    @SuppressWarnings("rawtypes")
    @GetMapping("") 
    public ResponseEntity<ApiResponse> getAllTasks() throws Exception {
        return taskService.getAllTask();
    }

    @GetMapping("/completed")
    public ResponseEntity<ApiResponse> getAllCompletedTasks() { 
        return taskService.findAllCompletedTask();
    }

    @GetMapping("/incomplete")
    public ResponseEntity<ApiResponse> getAllIncompleteTasks() { 
        return taskService.findAllInCompleteTask();
    } 

    @PostMapping("") 
    public ResponseEntity<ApiResponse> createTask(@RequestBody TaskDTO taskDTO) {
        Task task = this.modelMapper.map(taskDTO, Task.class);
        return this.taskService.createNewTask(task);
    } 

    @PatchMapping("/{id}") 
    public ResponseEntity<ApiResponse> updateTask(@PathVariable Long id, @RequestBody Task task) { 
        task.setId(id);
        return this.taskService.updateTask(task);
    } 
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<ApiResponse> getAllTasks(@PathVariable Task task) { 
        taskService.deleteTask(task); 
        return this.taskService.deleteTask(task);
    }
}