package com.kata.clientprofilefacade.exception;

import com.kata.clientprofilefacade.exception.individualexception.InvalidFullNameException;
import com.kata.clientprofilefacade.exception.phonenumberexception.InvalidPhoneNumberException;
import com.kata.clientprofilefacade.exception.rfpassportdocexception.InvalidPassportNumberException;
import com.kata.clientprofilefacade.exception.rfpassportdocexception.InvalidPassportSeriesException;
import org.kata.erroresponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationDocumentsExceptionHandler {

    @ExceptionHandler(InvalidPassportSeriesException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPassportSeriesException(InvalidPassportSeriesException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPassportNumberException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPassportNumberException(InvalidPassportNumberException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPassportNumberException(InvalidPhoneNumberException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFullNameException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPassportNumberException(InvalidFullNameException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
