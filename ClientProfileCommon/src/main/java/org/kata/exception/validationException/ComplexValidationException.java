package org.kata.exception.validationException;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ComplexValidationException extends RuntimeException {
    private final Map<String, String> errors;

    public String getCode() {return "01";}


    public Map<String, String> getErrors() {
        return errors;
    }
}
