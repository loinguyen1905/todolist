package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Task { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task")
    private String task; 
    @Column(name = "completed")
    private boolean completed; 
    public Task(String task, boolean completed) { 
        this.task = task; 
        this.completed = completed;
    }
}