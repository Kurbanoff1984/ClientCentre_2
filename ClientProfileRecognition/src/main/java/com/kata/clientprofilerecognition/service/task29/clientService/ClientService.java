package com.kata.clientprofilerecognition.service.task29.clientService;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

/**
 * Сервис отвечает за запрос в мкс Loader и мкс update по ресту
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {
    private final RestTemplate restTemplate;
    @Value("${URL_Loader}")
    private String URL_Loader ;
    @Value("${URL_Update}")
    private String URL_Update ;
    @Value("${URL_Update_loader}")
    private String updateUrl;

    //выполняет GET-запрос к микросервису Loader, чтобы получить старый документ
    private Optional<RFPassportDocRecognitionDto> fetchDocumentFromLoader(String icp) {
        try {
            String url = URL_Loader + "?icp=" + icp;

            ResponseEntity<RFPassportDocRecognitionDto> response = restTemplate.getForEntity(url, RFPassportDocRecognitionDto.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return Optional.ofNullable(response.getBody());
            } else {
                log.error("Не удалось получить документ из Loader. Код состояния: {}", response.getStatusCode().value());
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Произошла HTTP-ошибка при получении документа из Loader: {}", e.getMessage());

        } catch (RestClientException e) {
            log.error("Произошла ошибка при получении документа из Loader: {}", e.getMessage());

        }
        return Optional.empty();
    }



    //метод отправляет документ в мкс Update
    public void updateDocumentInMcsUpdate(RFPassportDocRecognitionDto newDocument) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<RFPassportDocRecognitionDto> requestEntity = new HttpEntity<>(newDocument, headers);
            ResponseEntity<Void> response = restTemplate.postForEntity(URL_Update, requestEntity, Void.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                log.info("Документ обновлен в микросервисе Update");
            } else {
                log.error("Не удалось обновить документ. Код состояния: {}", response.getStatusCode().value());
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Произошла HTTP-ошибка при обновлении документа в Update: {}", e.getMessage());

        } catch (RestClientException e) {
            log.error("Произошла ошибка при обновлении документа в Update: {}", e.getMessage());
        }
    }

    // метод сравнивает документы
    public void compareAndUploadDocument(RFPassportDocRecognitionDto newDocument) {
        fetchDocumentFromLoader(newDocument.getIcp()).ifPresent(oldDocument -> {
            if (oldDocument.getName().equals(newDocument.getName())
                    && oldDocument.getSurname().equals(newDocument.getSurname())
                    && oldDocument.getNumber().equals(newDocument.getNumber())) {
                log.info("Документы совпадают");
            } else {
                updateDocumentInMcsUpdate(newDocument);
            }
        });
    }
    //метод отправляет запрос на добавление документа
    public void addClientDocument(RFPassportDocRecognitionDto rfPassportDocRecognitionDto) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<RFPassportDocRecognitionDto> entity = new HttpEntity<>(rfPassportDocRecognitionDto, headers);
            ResponseEntity<String> response = restTemplate.exchange(updateUrl, HttpMethod.PUT, entity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                log.info("Документ обновлен: " + rfPassportDocRecognitionDto);
            } else {
                log.error("Ошибка обновления документа");
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("HTTP-ошибка при обновлении документа: {}", e.getMessage());
        } catch (RestClientException e) {
            log.error("Ошибка при обновлении документа: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Произошла неизвестная ошибка: {}", e.getMessage());

        }
    }
}
