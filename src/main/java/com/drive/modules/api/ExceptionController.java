package com.drive.modules.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> hadleResponseStatusException(MethodArgumentNotValidException exception) {
        Map<String,String> error = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((e) -> {
            final String fieldName = ((FieldError)e).getField();
            error.put(fieldName, e.getDefaultMessage());
        });
        return ResponseEntity.status(400).body(error);
    }

}
