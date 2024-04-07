package com.loinguyen1905.todo.dto;

public class CreatedByDTO {
    
    private Long userId;

    private String time;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", time='" + getTime() + "'" +
            "}";
    }
}