package com.loinguyen1905.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.loinguyen1905.todo.entities.Task;

import java.util.List; 

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> { 
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findAll();
    public Task getById(Long id);
}