package com.loinguyen1905.todo.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.loinguyen1905.todo.util.modelmapper.MapperUtil;

@Configuration
public class ModelMapperConfig {
    @Order(1)
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    @Order(2)
    @Bean
    public MapperUtil mapUtil() {
        MapperUtil mapUtil = new MapperUtil();
        return mapUtil;
    }
}