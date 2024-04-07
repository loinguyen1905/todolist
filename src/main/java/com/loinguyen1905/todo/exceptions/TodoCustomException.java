package com.loinguyen1905.todo.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class TodoCustomException {
    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date localDateTime;
    private String message;
    private String ErrorMessage;

    public TodoCustomException(HttpStatus httpStatus, Date date, String message, String ErrorMessage) {
        this.httpStatus = httpStatus;
        this.localDateTime = date;
        this.message = message;
        this.ErrorMessage = ErrorMessage;
    }

    // TodoCustomException(HttpStatus httpStatus) {
    //     this();
    //     this.httpStatus=httpStatus;
    //     this.code=httpStatus.value();
    // }

    // TodoCustomException(HttpStatus httpStatus, Throwable error) {
    //     this();
    //     this.httpStatus=httpStatus;
    //     this.message="An error has occured";
    //     this.ErrorMessage=error.getLocalizedMessage();
    // }

    // TodoCustomException(HttpStatus httpStatus, String message, Throwable error){
    //     this();
    //     this.httpStatus=httpStatus;
    //     this.message=message;
    //     this.ErrorMessage=error.getLocalizedMessage();
    // }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}