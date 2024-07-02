package com.example.NBP.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Object> handleNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Object> handleBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerError() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<Object> handleResourceAccessException() {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
    }
}