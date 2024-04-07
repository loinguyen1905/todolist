package com.loinguyen1905.todo.dto;

enum TaskStatus {
    CREATED,
    PROCESSING,
    FINISHED,
    CANCEL
}

public class TaskDTO {
    private Long id;

    private String title; 

    private TaskStatus status;

    private String description;

    private boolean completed;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String title, TaskStatus status, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.completed = completed;
    }

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

    public TaskStatus getStatus() {
        return this.status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", status='" + getStatus() + "'" +
            ", description='" + getDescription() + "'" +
            ", completed='" + isCompleted() + "'" +
            "}";
    }
}