package com.kata.clientprofilefacade.service.impl;

import com.kata.clientprofilefacade.dao.RFPassportDocMaskDao;
import com.kata.clientprofilefacade.dto.RFPassportDocDTO;
import com.kata.clientprofilefacade.service.RFPassportDocMaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RFPassportDocMaskServiceImpl implements RFPassportDocMaskService {

    private final RFPassportDocMaskDao rfPassportDocMaskDao;

    @Override
    public RFPassportDocDTO maskPassport(RFPassportDocDTO rfPassportDoc) {
        return rfPassportDocMaskDao.maskPassport(rfPassportDoc);
    }
}
