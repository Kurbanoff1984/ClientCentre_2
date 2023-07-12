package com.kata.clientprofilerecognition.service.task29;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import com.kata.clientprofilerecognition.service.task29.service.Loader;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientStatusChecker {
    private final Loader loader;


    public String checkClientStatus(RFPassportDocRecognitionDto rfPassportDocRecognitionDto) {
        if (rfPassportDocRecognitionDto.isClientStatus()) {
            // метод на отправку в мкс update на обновление документа
            return "Requires verification and updating of the document";
        } else {
            loader.addClientDocument(rfPassportDocRecognitionDto);
            return "Valid";
        }
    }
}
