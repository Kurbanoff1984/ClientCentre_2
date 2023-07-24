package com.kata.clientprofilefacade.util;

import com.kata.clientprofilefacade.exception.InvalidPhoneNumberException;
import lombok.extern.slf4j.Slf4j;

import static com.kata.clientprofilefacade.constant.PhoneNumberRegExp.PHONE_NUMBER_FORMAT;

/**
 * This class provides helper functions for Phone Number class
 *
 *  @author Chong Nguyen
 */
@Slf4j
public class PhoneNumberUtils {

    /**
     * This method checks that the phone number is not empty and has the correct format, where there are no letters
     * @param phoneNumber Your phone number
     */
    public static void validatePhoneNumber(String phoneNumber) {
        log.info("Validate phone number: {}", phoneNumber);
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            log.error("PhoneNumber is null or empty");
            throw new InvalidPhoneNumberException("Phone number cannot be null or empty");
        }
        if (!isPhoneNumberValid(phoneNumber)) {
            log.error("Phone number cannot contain invalid characters or invalid format");
            throw new InvalidPhoneNumberException("Phone number cannot contain invalid characters or invalid format");
        }
    }
    /**
     * This method checks that the phone number has the correct format
     * @param phoneNumber Your phone number
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER_FORMAT);
    }
}
