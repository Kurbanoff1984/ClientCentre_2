package com.kata.clientprofilefacade.exception.handler;

import com.kata.clientprofilefacade.exception.MetricsProcessingException;
import org.kata.erroresponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MetricsExceptionHandler {

    @ExceptionHandler(MetricsProcessingException.class)
    public ResponseEntity<ErrorResponse> handleMetricsProcessingException(MetricsProcessingException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, 500);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
