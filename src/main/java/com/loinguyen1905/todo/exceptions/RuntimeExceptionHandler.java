package com.loinguyen1905.todo.exceptions;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.loinguyen1905.todo.core.interceptor.RestTemplateFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.el.MethodNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.NotSupportedException;

import org.apache.coyote.BadRequestException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RuntimeExceptionHandler extends RuntimeException{
  private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateFilter.class);
  private static final Map<Class<? extends Exception>, Integer> exceptionStatusMap = new HashMap<>();

  static {
    exceptionStatusMap.put(NotFoundException.class, 404);
    exceptionStatusMap.put(Unauthorized.class, 401);
  }

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private HttpServletResponse response;

  @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
  public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
    LOGGER.info("Request: {} {}", request.getMethod(), request.getRequestURI());
    Object result = joinPoint.proceed();
    LOGGER.info("Response: {}", response.getStatus());
    return result;
  }

  @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> badRequestException(BadRequestException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            new Date(),
            ex.getClass().getSimpleName(),
            ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorMessage> handleNoResourceFoundException(NoResourceFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            new Date(),
            ex.getClass().getSimpleName(),
            ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

  @ExceptionHandler( HttpRequestMethodNotSupportedException.class )
  public ResponseEntity<ErrorMessage> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.METHOD_NOT_ALLOWED.value(),
        new Date(),
        ex.getClass().getSimpleName(),
        ex.getMessage());
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorMessage> handleAccessDeniedException(AccessDeniedException ex) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.FORBIDDEN.value(),
        new Date(),
        ex.getClass().getSimpleName(),
        ex.getMessage());
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler({ IllegalArgumentException.class, IllegalStateException.class })
  public ResponseEntity<ErrorMessage> handleConflict(RuntimeException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.CONFLICT.value(),
        new Date(),
        ex.getClass().getSimpleName(),
        ex.getMessage());
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ErrorMessage> handlerEntityNotFound(NoHandlerFoundException ex) {
    ErrorMessage message = new ErrorMessage(
      HttpStatus.NOT_FOUND.value(),
      new Date(),
      ex.getClass().getSimpleName(),
      ex.getMessage());
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Unauthorized.class)
  public ResponseEntity<ErrorMessage> handlerUnauthorized(Unauthorized ex) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.UNAUTHORIZED.value(),
        new Date(),
        ex.getClass().getSimpleName(),
        ex.getMessage());
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(InternalServerError.class)
  public ResponseEntity<ErrorMessage> handlerInternalServerError(InternalServerError ex) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getClass().getSimpleName(),
        ex.getMessage());
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}