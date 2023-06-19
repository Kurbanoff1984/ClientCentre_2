package com.kata.clientprofilefacade.dao.impl;

import com.kata.clientprofilefacade.dao.RFPassportDocMaskDao;
import com.kata.clientprofilefacade.dto.RFPassportDocDTO;
import com.kata.clientprofilefacade.util.RFPassportDocUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * This class is for RFPassportDoc masking
 *
 * @author Chong Nguyen
 */
@Repository
@Slf4j
public class RFPassportDocMaskImpl implements RFPassportDocMaskDao {

    /**
     * This method checks for null and then masks the passport series and number
     * @param rfPassportDoc Your RFPassportDoc object, which contains your series and passport number
     * @return Disguised object
     */
    @Override
    public RFPassportDocDTO maskPassport(RFPassportDocDTO rfPassportDoc) {
        log.info("Masking the series and number of the passport",rfPassportDoc);
        RFPassportDocUtils.checkPassport(rfPassportDoc);
        rfPassportDoc.setSeries(rfPassportDoc.getSeries().replaceAll("(\\d{2})\\d{2}", "$1**"));
        rfPassportDoc.setNumber(rfPassportDoc.getNumber().replaceAll("\\d{4}(\\d{2})", "****$1"));
        return rfPassportDoc;
    }
}
