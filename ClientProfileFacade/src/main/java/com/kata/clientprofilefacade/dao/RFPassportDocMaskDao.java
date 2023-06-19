package com.kata.clientprofilefacade.dao;

import com.kata.clientprofilefacade.dto.RFPassportDocDTO;
import org.kata.entity.document.RFPassportDoc;

public interface RFPassportDocMaskDao {
    RFPassportDocDTO maskPassport(RFPassportDocDTO rfPassportDoc);
}
