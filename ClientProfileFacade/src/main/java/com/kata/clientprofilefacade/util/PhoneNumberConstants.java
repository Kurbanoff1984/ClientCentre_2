package com.kata.clientprofilefacade.util;

/**
 * This class is designed to store constant values for the Phone Number class
 */
public class PhoneNumberConstants {
    /**
     * This string is for properly formatting the phone number
     */
    public static final String PHONE_NUMBER_FORMAT = "^\\+7 \\d{3} \\d{3}-\\d{2}-\\d{2}$";
    /**
     * This string is for masking the phone number
     */
    public static final String PHONE_NUMBER_REGEX_MASK_FORMAT = "(\\d{3}) (\\d{3})-(\\d{2})-(\\d{2})";
    /**
     * This string is for a character to mask
     */
    public static final String PHONE_NUMBER_REPLACEMENT_FORMAT = "$1 $2 ***-**-$3";
}
