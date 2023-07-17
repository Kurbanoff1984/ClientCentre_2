package org.kata.config;


import lombok.extern.slf4j.Slf4j;
import org.kata.erroresponse.ComplexValidationErrorsResponse;
import org.kata.erroresponse.ErrorResponse;
import org.kata.exception.NotFoundEntityException;
import org.kata.exception.validationException.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * глобальный обработчик исключений для всех контроллеров ProfileService
 */

@RestControllerAdvice
@Slf4j
public class ExceptionRestController {

    /**
     * Метод обработки исключений типа NotFoundEntityException - формирует тело ответа ErrorResponse и отсылает его со статусом 400
     * @param exception
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<ErrorResponse> notFoundEntityException(NotFoundEntityException exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> missingServletRequestParameterException() {
        ErrorResponse error = new ErrorResponse(
                "invalid user IDs",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegalArgumentException(IllegalArgumentException exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


//-------------------------------------------------------------------------------------------------------------------

    /**
     *Комплексный результат валидации объекта
     */
    @ExceptionHandler(ComplexValidationException.class)
    public ResponseEntity<ComplexValidationErrorsResponse> complexValidation(ComplexValidationException e) {
        ComplexValidationErrorsResponse complexValidationErrorsResponse = new ComplexValidationErrorsResponse(
                e.getErrors(),
                LocalDateTime.now(),
                e.getCode()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(complexValidationErrorsResponse);
    }
}
