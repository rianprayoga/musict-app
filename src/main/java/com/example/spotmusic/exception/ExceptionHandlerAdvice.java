package com.example.spotmusic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = {
            ResourceNotFoundException.class,
    })
    public ResponseEntity<Map<String,String>> handleResourceNotFoundException(RuntimeException runtimeException){
        Map<String,String> message = new HashMap<>();
        message.put("error", runtimeException.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}
