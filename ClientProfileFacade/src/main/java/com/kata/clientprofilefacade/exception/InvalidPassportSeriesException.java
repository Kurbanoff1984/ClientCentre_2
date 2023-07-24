package com.kata.clientprofilefacade.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class is an exception for RFPassportDoc class
 *
 * @author Chong Nguyen
 */
@Slf4j
public class InvalidPassportSeriesException extends RuntimeException {

    public InvalidPassportSeriesException(String message) {
        super(message);
        log.error("InvalidPassportSeriesException {}",message);
    }
}
