package com.kata.clientprofilefacade.exception.phonenumberexception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class is an exception for Phone Number class
 *
 * @author Chong Nguyen
 */
@Slf4j
public class InvalidPhoneNumberException extends RuntimeException {

    public InvalidPhoneNumberException(String message) {
        super(message);
        log.error("InvalidPhoneNumberException {}",message);
    }
}
