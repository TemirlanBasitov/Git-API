package com.gitapi.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<ErrorDetails> handleNotFoundException(HttpClientErrorException.NotFound exception, WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails( HttpStatus.NOT_FOUND.value(), "Incorrect username" );
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> xmlTypeExceptionWrapper( XmlTypeExceptionWrapper exceptionWrapper, WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails( HttpStatus.NOT_ACCEPTABLE.value(), exceptionWrapper.getMessage() );
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }

}
