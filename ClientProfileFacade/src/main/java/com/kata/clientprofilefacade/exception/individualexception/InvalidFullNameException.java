package com.kata.clientprofilefacade.exception.individualexception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is an exception for Individual class
 *
 * @author Chong Nguyen
 */
@Slf4j
public class InvalidFullNameException extends RuntimeException {

    public InvalidFullNameException(String message) {
        super(message);
        log.error("InvalidFullNameException {}",message);
    }

    public InvalidFullNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
