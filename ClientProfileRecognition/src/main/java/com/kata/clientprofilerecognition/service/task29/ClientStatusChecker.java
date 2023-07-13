package com.kata.clientprofilerecognition.service.task29;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import com.kata.clientprofilerecognition.service.task29.component.ClientService;
import com.kata.clientprofilerecognition.service.task29.service.Loader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientStatusChecker {
    private final Loader loader;
    private final ClientService clientService;


    public void checkClientStatus(RFPassportDocRecognitionDto newDocument) {
        if (newDocument.isClientStatus()) {
            clientService.updateDocumentInMcsUpdate(newDocument);
        } else {
            loader.addClientDocument(newDocument);
        }
    }
}
