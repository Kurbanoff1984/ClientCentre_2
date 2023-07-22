package com.kata.clientprofilefacade.dao.impl;

import com.kata.clientprofilefacade.dao.MaskingDao;
import com.kata.clientprofilefacade.dto.PhoneNumberDTO;
import com.kata.clientprofilefacade.util.IndividualUtils;
import com.kata.clientprofilefacade.util.PhoneNumberUtils;
import com.kata.clientprofilefacade.util.RFPassportDocUtils;
import lombok.extern.slf4j.Slf4j;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.dto.response.IndividualResponseDto;
import org.kata.dto.response.RFPassportDocResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.kata.clientprofilefacade.constant.PhoneNumberRegExp.PHONE_NUMBER_REGEX_MASK_FORMAT;
import static com.kata.clientprofilefacade.constant.PhoneNumberRegExp.PHONE_NUMBER_REPLACEMENT_FORMAT;


/**
 * This class is for masking
 *
 * @author Chong Nguyen
 */
@Repository
@Slf4j
public class MaskingImpl implements MaskingDao {

    /**
     * This method checks for null and then masks the passport series and number
     * @param documentsResponseDto Your DocumentsResponseDto object, which RFPassport with series and passport number
     * @return Disguised object
     */
    @Override
    public DocumentsResponseDto maskPassport(DocumentsResponseDto documentsResponseDto) {

        List<RFPassportDocResponseDto> rfPassportDocs = (List<RFPassportDocResponseDto>) documentsResponseDto.getRfPassportDocs();
        for (RFPassportDocResponseDto rfPassportDoc : rfPassportDocs) {
            RFPassportDocUtils.checkPassport(rfPassportDoc);
            rfPassportDoc.setSeriesRFP(rfPassportDoc.getSeriesRFP().replaceAll("(\\d{2})\\d{2}", "$1**"));
            rfPassportDoc.setNumberRFP(rfPassportDoc.getNumberRFP().replaceAll("\\d{4}(\\d{2})", "****$1"));
        }
        log.info("Masking the series and number of the passport",documentsResponseDto);

        return documentsResponseDto;
    }

    /**
     * This method first checks that it is null and then masks the last name and changes the full name string
     * @param individualResponseDto Your IndividualResponseDto object that includes the first name, last name and full name
     * @return Disguised object
     */
    @Override
    public IndividualResponseDto maskName(IndividualResponseDto individualResponseDto) {
        log.info("Surname masking",individualResponseDto);

        IndividualUtils.fullNameConfirmation(individualResponseDto);

        individualResponseDto.setSurname(individualResponseDto.getSurname().replaceAll("(?<=.).", "*"));

        String[] nameParts = individualResponseDto.getFullName().split(" ");
        StringBuilder shortenedName = new StringBuilder();

        for (int i = 1; i < nameParts.length; i++) {
            if ( i != 0 && !nameParts[i].isEmpty() && nameParts[i] != null) {
                shortenedName.append(nameParts[i] + " ");
            }
        }
        shortenedName.append(individualResponseDto.getSurname());

        individualResponseDto.setFullName(shortenedName.toString());
        return individualResponseDto;
    }

    /**
     * This method checks for null and then masks the phone number
     * @param phoneNumber Your Phone number object where there is your phone number
     * @return Disguised object
     */
    @Override
    public PhoneNumberDTO maskPhoneNumber(PhoneNumberDTO phoneNumber) {
        log.info("Masking phone number", phoneNumber);
        PhoneNumberUtils.validatePhoneNumber(phoneNumber.getValue());
        phoneNumber.setValue(phoneNumber.getValue().replaceAll(
                PHONE_NUMBER_REGEX_MASK_FORMAT,
                PHONE_NUMBER_REPLACEMENT_FORMAT));

        return phoneNumber;
    }
}
