package com.kata.clientprofilerecognition.service.task29.component;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;


@Component
@AllArgsConstructor
@Slf4j
public class ClientService {
    private final RestTemplate restTemplate;
    String URL_Loader= "http://localhost:8081/api/client/documents/getDoc";
    String URL_Update = "http://localhost:8079/update";//примерный урл

//выполняет GET-запрос к микросервису Loader, чтобы получить старый документ
    private RFPassportDocRecognitionDto fetchDocumentFromLoader (String rfPassportDocRecognitionDto){
        ResponseEntity<RFPassportDocRecognitionDto> response = restTemplate.getForEntity(URL_Loader,RFPassportDocRecognitionDto.class);
        return response.getBody();
    }
    //метод отправляет документ в мкс Update
    public void updateDocumentInMcsUpdate(RFPassportDocRecognitionDto newDocument){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RFPassportDocRecognitionDto> requestEntity = new HttpEntity<>(newDocument,headers);
        ResponseEntity<Void> response = restTemplate.postForEntity(URL_Update,requestEntity, Void.class);
        if (response.getStatusCode().is2xxSuccessful()){
            log.info("Document updated in microservice Update");
        } else {
            log.error("Failed to update document");
        }
    }
    //метод сравнивает новый и старый документ
    // не пойму нужен ли этот метод
    public void compareAndUploadDocument(RFPassportDocRecognitionDto newDocument) {
        RFPassportDocRecognitionDto oldDocument = fetchDocumentFromLoader(newDocument.getIcp());

        if (oldDocument.equals(newDocument)) {
            log.info("документы совпадают");
        } else {
            updateDocumentInMcsUpdate(newDocument);
        }
    }
}
