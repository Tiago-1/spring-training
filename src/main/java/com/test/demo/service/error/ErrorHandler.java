package com.test.demo.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class ErrorHandler {

    
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorEntity exception(Exception e) {
        e.printStackTrace();
        return new ErrorEntity(e, e.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundError.class)
    public ErrorEntity exception(ResourceNotFoundError e) {
        return new ErrorEntity("not_found", e.getMessage());
    }

}
