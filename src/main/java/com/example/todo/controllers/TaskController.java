package com.example.todo.controllers;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.todo.models.Task;
import com.example.todo.services.TaskService;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController { 
  
    @Autowired
    private TaskService taskService; 
    @GetMapping("") 
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() { 
        return ResponseEntity.ok(taskService.findAllCompletedTask()); 
    } 
    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() { 
        return ResponseEntity.ok(taskService.findAllInCompleteTask());
    } 
    @PostMapping("") 
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createNewTask(task)); 
    } 
    @PatchMapping("/{id}") 
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) { 
        task.setId(id); 
        return ResponseEntity.ok(taskService.updateTask(task)); 
    } 
    @DeleteMapping("/{id}") 
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Task task) { 
        taskService.deleteTask(task); 
        return ResponseEntity.ok(true); 
    }
}