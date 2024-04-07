package com.loinguyen1905.todo.exceptions;

import java.util.Date;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletResponse;

@Order(2)
@ControllerAdvice
public class TodoRestExceptionHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> resourceNotFoundException(Exception ex, WebRequest request, HttpServletResponse response)  {
    ErrorMessage message = new ErrorMessage(
      HttpStatus.BAD_REQUEST.value(),
        new Date(),
        ex.getClass().getSimpleName(),
        ex.getMessage()
      );
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
  }
}