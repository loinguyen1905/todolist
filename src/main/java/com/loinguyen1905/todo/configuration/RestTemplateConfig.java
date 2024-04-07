package com.loinguyen1905.todo.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.loinguyen1905.todo.core.interceptor.ExecutionTimeInterceptor;
import com.loinguyen1905.todo.core.interceptor.RestTemplateFilter;

//@Configuration annotation on a Spring class indicates that the class is a Spring configuration and defines a bean or several beans in the context of the application.
@Configuration
public class RestTemplateConfig implements WebMvcConfigurer {

    @Autowired
    private ExecutionTimeInterceptor executionTimeInterceptor;

    @Autowired
    private RestTemplateFilter restTemplateFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executionTimeInterceptor);
    }

    //A bean in Spring is an object managed by the Spring container that can be used in other parts of the application.
    //which are used to define and configure the beans in the context of the application. 
    //These methods can perform the necessary configuration, such as creating object instances, setting properties, setting dependencies, and returning objects that will become Spring-managed beans.
    @Bean
    RestTemplate restTemplate() {
        //BufferingClientHttpRequestFactory: this class will buffer the request/response in JVM memory for multiple usage.
        //At this point we must emphasize the initialisation of the RestTemplate.
        final RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.setInterceptors(Collections.singletonList(restTemplateFilter));
        return restTemplate;
    }
}