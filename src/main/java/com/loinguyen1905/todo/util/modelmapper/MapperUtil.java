package com.loinguyen1905.todo.util.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {
    
    @Autowired
    public static ModelMapper modelMapper;

    public MapperUtil() {}

    public <S, T> T mapObject(S source, Class<T> target) {
        T t = modelMapper.map(modelMapper, target);
        return t;
    }

    public <S, T> List<T> mapList(List<S> source , Class<T> targetClass) {
        List<T> ts = source
            .stream()
            .map(element -> modelMapper.map(element, targetClass))
            .collect(Collectors.toList());
        return ts;
    }
}