package org.kata.clientprofileservice.service.rest.Impl;


import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.rest.RestTemplateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service для rest общения между ProfileService и ProfileLoader
 */
@Service
@RequiredArgsConstructor
public class RestTemplateServiceImpl implements RestTemplateService {
    private final RestTemplate restTemplate;

    /**
     * контекстный путь к ProfileLoader
     */
    @Value("${loaderservice.base.url}")
    private String loaderBaseURL;

    @Override
    public <T> T getEntity(String url, Class<T> responseType) {
        ResponseEntity<T> response = restTemplate.exchange(loaderBaseURL + url, HttpMethod.GET, null, responseType);
        return response.getBody();
    }

    @Override
    public <T> T createEntity(String url, Object request, Class<T> responseType) {
        HttpEntity<Object> entity = new HttpEntity<>(request);
        ResponseEntity<T> response = restTemplate.exchange(loaderBaseURL + url, HttpMethod.POST, entity, responseType);
        return response.getBody();
    }

    @Override
    public <T> T updateEntity(String url, Object request, Class<T> responseType) {
        HttpEntity<Object> entity = new HttpEntity<>(request);
        ResponseEntity<T> response = restTemplate.exchange(loaderBaseURL + url, HttpMethod.PUT, entity, responseType);
        return response.getBody();
    }

    @Override
    public void deleteEntity(String url) {
        restTemplate.delete(loaderBaseURL + url);
    }


}

