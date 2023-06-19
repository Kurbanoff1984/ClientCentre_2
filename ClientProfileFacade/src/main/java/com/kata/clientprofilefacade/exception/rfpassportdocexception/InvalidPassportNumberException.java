package com.kata.clientprofilefacade.exception.rfpassportdocexception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class is an exception for RFPassportDoc class
 *
 * @author Chong Nguyen
 */
@Slf4j
public class InvalidPassportNumberException extends RuntimeException {

    public InvalidPassportNumberException(String message) {
        super(message);
        log.error("InvalidPassportNumberException: {}",message);
    }
}
