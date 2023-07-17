package com.kata.clientprofilefacade.service.impl;

import com.kata.clientprofilefacade.dao.MaskingDao;
import com.kata.clientprofilefacade.dto.PhoneNumberDTO;
import com.kata.clientprofilefacade.service.MaskingService;
import lombok.AllArgsConstructor;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.dto.response.IndividualResponseDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaskingServiceImpl implements MaskingService {

    private final MaskingDao maskingDao;
    @Override
    public DocumentsResponseDto maskPassport(DocumentsResponseDto documentsResponseDto) {
        return maskingDao.maskPassport(documentsResponseDto);
    }

    @Override
    public IndividualResponseDto maskName(IndividualResponseDto individualResponseDto) {
        return maskingDao.maskName(individualResponseDto);
    }

    @Override
    public PhoneNumberDTO maskPhoneNumber(PhoneNumberDTO phoneNumber) {
        return maskingDao.maskPhoneNumber(phoneNumber);
    }


}
