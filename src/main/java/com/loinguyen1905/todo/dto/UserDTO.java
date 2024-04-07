package com.loinguyen1905.todo.dto;

public class UserDTO {

    private Long id;
    
    private String role;

    private String username;

    private String email;

    public UserDTO(String role, String username, String password, String email) {
        this.role = role;
        this.username = username;
        this.email = email;
    }

    public UserDTO() {}

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " role='" + getRole() + "'" +
            ", id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}