package com.medical_back.medical.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectsInClassNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ObjectsInClassNotFoundException exception) {
        return new ResponseEntity<>("Object doesn't exist", HttpStatus.BAD_REQUEST);
    }

}
