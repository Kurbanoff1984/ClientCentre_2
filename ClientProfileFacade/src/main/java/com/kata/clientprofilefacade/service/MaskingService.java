package com.kata.clientprofilefacade.service;

import com.kata.clientprofilefacade.dto.PhoneNumberDTO;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.dto.response.IndividualResponseDto;

public interface MaskingService {

    DocumentsResponseDto maskPassport(DocumentsResponseDto documentsResponseDto);
    IndividualResponseDto maskName(IndividualResponseDto individualResponseDto);
    PhoneNumberDTO maskPhoneNumber(PhoneNumberDTO phoneNumber);
}
