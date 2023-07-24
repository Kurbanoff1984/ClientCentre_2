package com.kata.clientprofilefacade.util;

import com.kata.clientprofilefacade.exception.InvalidPassportNumberException;
import com.kata.clientprofilefacade.exception.InvalidPassportSeriesException;
import lombok.extern.slf4j.Slf4j;
import org.kata.dto.response.RFPassportDocResponseDto;


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
    public static void checkPassport(RFPassportDocResponseDto rfPassportDoc) {

        if (rfPassportDoc.getSeriesRFP() == null || rfPassportDoc.getSeriesRFP().isEmpty()) {
            log.error("Passport series is null or empty");
            throw new InvalidPassportSeriesException("Passport series cannot be null or empty");
        }
        if (rfPassportDoc.getSeriesRFP().length() != 4) {
            log.error("Passport series must be 4 digits long");
            throw new InvalidPassportSeriesException("Passport series must be 4 digits long");
        }
        if (!rfPassportDoc.getSeriesRFP().matches("\\d+")) {
            log.error("Passport series must contain only numbers");
            throw new InvalidPassportSeriesException("Passport series must contain only numbers");
        }
        if (rfPassportDoc.getNumberRFP() == null || rfPassportDoc.getNumberRFP().isEmpty()) {
            log.error("Passport number cannot be null or empty");
            throw new InvalidPassportNumberException("Passport number cannot be null or empty");
        }
        if (rfPassportDoc.getNumberRFP().length() != 6) {
            log.error("Passport number must be 6 digits long");
            throw new InvalidPassportNumberException("Passport number must be 6 digits long");
        }
        if (!rfPassportDoc.getNumberRFP().matches("\\d+")) {
            log.error("Passport number must contain only numbers");

            throw new InvalidPassportNumberException("Passport number must contain only numbers");
        }
    }
}
