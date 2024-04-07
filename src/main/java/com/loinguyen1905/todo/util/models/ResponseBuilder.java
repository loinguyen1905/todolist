package com.loinguyen1905.todo.util.models;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class ResponseBuilder {
    @SuppressWarnings("rawtypes")
    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Object data, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message).withHttpHeader(httpHeader)
                .withData(data).withOtherParams(otherParams).build();
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Object data, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).withOtherParams(otherParams).build();
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withOtherParams(otherParams).build();
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).withData(data).build();
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).withOtherParams(otherParams).build();
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).build();
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).build();
    }
}
