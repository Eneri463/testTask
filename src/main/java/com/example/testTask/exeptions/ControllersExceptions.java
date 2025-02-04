package com.example.testTask.exeptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllersExceptions {
   // @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    protected ResponseEntity<String> handleValidationExceptions(Exception ex)
    {
        return new ResponseEntity<>("Incorrect data entered", HttpStatus.BAD_REQUEST);
    }
}
