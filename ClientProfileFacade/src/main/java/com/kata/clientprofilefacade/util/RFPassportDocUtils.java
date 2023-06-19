package com.kata.clientprofilefacade.util;

import com.kata.clientprofilefacade.dto.RFPassportDocDTO;
import com.kata.clientprofilefacade.exception.rfpassportdocexception.InvalidPassportNumberException;
import com.kata.clientprofilefacade.exception.rfpassportdocexception.InvalidPassportSeriesException;
import lombok.extern.slf4j.Slf4j;

/**
 * This class provides helper functions for RFPassportDoc class
 *
 *  @author Chong Nguyen
 */
@Slf4j
public class RFPassportDocUtils {

    /**
     * This method checks that the series and passport number are not empty and have the correct format
     * @param rfPassportDoc Your RFPassportDoc object where there is a series and passport number
     */
    public static void checkPassport(RFPassportDocDTO rfPassportDoc) {
        if (rfPassportDoc.getSeries() == null || rfPassportDoc.getSeries().isEmpty()) {
            log.error("Passport series is null or empty");
            throw new InvalidPassportSeriesException("Passport series cannot be null or empty");
        }
        if (rfPassportDoc.getSeries().length() != 4) {
            log.error("Passport series must be 4 digits long");
            throw new InvalidPassportSeriesException("Passport series must be 4 digits long");
        }
        if (!rfPassportDoc.getSeries().matches("\\d+")) {
            log.error("Passport series must contain only numbers");
            throw new InvalidPassportSeriesException("Passport series must contain only numbers");
        }
        if (rfPassportDoc.getNumber() == null || rfPassportDoc.getNumber().isEmpty()) {
            log.error("Passport number cannot be null or empty");
            throw new InvalidPassportNumberException("Passport number cannot be null or empty");
        }
        if (rfPassportDoc.getNumber().length() != 6) {
            log.error("Passport number must be 6 digits long");
            throw new InvalidPassportNumberException("Passport number must be 6 digits long");
        }
        if (!rfPassportDoc.getNumber().matches("\\d+")) {
            log.error("Passport number must contain only numbers");
            throw new InvalidPassportNumberException("Passport number must contain only numbers");
        }
    }
}
