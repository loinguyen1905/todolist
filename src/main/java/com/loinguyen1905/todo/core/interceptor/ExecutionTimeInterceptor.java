package com.loinguyen1905.todo.core.interceptor;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//An interface that allows you to intercept the incoming and outgoing HTTP messages at the level of the DispatcherServlet
@Component
public class ExecutionTimeInterceptor implements HandlerInterceptor {
    
    private long startTime;

    // This method is called before the handler method is executed. It returns a boolean value indicating whether the execution chain should continue or not.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    // This method is called after the handler method is executed, but before the view is rendered. It allows us to modify the ModelAndView object before it is rendered.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
    }
    
    @Override //This method is called after the view is rendered. It allows us to perform any cleanup tasks.
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Cleanup code goes here
    }
}