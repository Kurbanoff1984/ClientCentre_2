package com.kata.clientprofilefacade.exception;

import org.kata.erroresponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;

@ControllerAdvice
public class RestTemplateExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        String responseBody = ex.getResponseBodyAsString();
        return new ResponseEntity<>(responseBody, status);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> handleIOException(IOException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Internal server error occurred while processing the request", HttpStatus.INTERNAL_SERVER_ERROR, 500);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<org.kata.erroresponse.ErrorResponse> handleResourceAccessException(IOException ex) {
        System.out.println(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("The requested resource is currently unavailable", HttpStatus.SERVICE_UNAVAILABLE, 503);
        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageConversionException(HttpMessageConversionException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Failed to convert the request/response message", HttpStatus.INTERNAL_SERVER_ERROR, 400);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Object> handleHttpServerErrorException(HttpServerErrorException ex) {
        HttpStatus statusCode = (HttpStatus) ex.getStatusCode();
        ErrorResponse errorResponse = null;
        if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR) {
            errorResponse = new ErrorResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, 500);

        } else if (statusCode == HttpStatus.SERVICE_UNAVAILABLE) {
            errorResponse = new ErrorResponse("Service Unavailable", HttpStatus.SERVICE_UNAVAILABLE, 503);
        }

        return new ResponseEntity<>(errorResponse, statusCode);
    }

}
