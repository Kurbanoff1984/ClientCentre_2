package org.kata.clientprofileservice.service.rest;


public interface RestTemplateService {
    <T> T getEntity(String url, Class<T> responseType);

    <T> T createEntity(String url, Object request, Class<T> responseType);

    <T> T updateEntity(String url, Object request, Class<T> responseType);

    void deleteEntity(String url);

}
