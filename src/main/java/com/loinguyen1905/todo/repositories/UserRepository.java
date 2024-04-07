package com.loinguyen1905.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.todo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}