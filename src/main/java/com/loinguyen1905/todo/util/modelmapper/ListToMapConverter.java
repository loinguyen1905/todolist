package com.loinguyen1905.todo.util.modelmapper;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ListToMapConverter {

    public Map<Integer, List<String>> groupingByStringLength(List<String> source, 
        Supplier<Map<Integer, List<String>>> mapSupplier, 
        Supplier<List<String>> listSupplier) {
        
        return source.stream()
            .collect(Collectors.groupingBy(String::length, mapSupplier, Collectors.toCollection(listSupplier)));
    }
    
    public Map<Integer, List<String>> streamCollectByStringLength(List<String> source, 
        Supplier<Map<Integer, List<String>>> mapSupplier, 
        Supplier<List<String>> listSupplier) {
        
        BiConsumer<Map<Integer, List<String>>, String> accumulator = (response, element) -> {
            Integer key = element.length();
            List<String> values = response.getOrDefault(key, listSupplier.get());
            values.add(element);
            response.put(key, values);
        };

        BiConsumer<Map<Integer, List<String>>, Map<Integer, List<String>>> combiner = (res1, res2) -> {
            res1.putAll(res2);
        };

        return source.stream()
            .collect(mapSupplier, accumulator, combiner);
    }
    
    public Map<Integer, List<String>> collectorToMapByStringLength(List<String> source, 
        Supplier<Map<Integer, List<String>>> mapSupplier, 
        Supplier<List<String>> listSupplier) {
        
        Function<String, Integer> keyMapper = String::length;

        Function<String, List<String>> valueMapper = (element) -> {
            List<String> collection = listSupplier.get();
            collection.add(element);
            return collection;
        };

        BinaryOperator<List<String>> mergeFunction = (existing, replacement) -> {
            existing.addAll(replacement);
            return existing;
        };

        return source.stream()
            .collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapSupplier));
    }
}