package com.loinguyen1905.todo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Task { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title; 
    
    @Column(name = "completed")
    private boolean completed;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted")
    private boolean deleted;

    
    // private Object deletedBy;

    
    @ManyToOne(cascade = jakarta.persistence.CascadeType.ALL) // Optional relationship configuration
    @JoinColumn(name = "created_by")
    private CreatedBy createdBy;

    // @Column(name = "performedBy")
    // private JSONPObject performedBy;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    // public Object getDeletedBy() {
    //     return this.deletedBy;
    // }

    // public void setDeletedBy(Object deletedBy) {
    //     this.deletedBy = deletedBy;
    // }

    // public Object getPerformedBy() {
    //     return this.performedBy;
    // }

    // public void setPerformedBy(Object performedBy) {
    //     this.performedBy = performedBy;
    // }

    public Object getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }
}