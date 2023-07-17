package com.kata.clientprofilefacade.dao.impl;

import com.kata.clientprofilefacade.dao.ProfileAvatarDao;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@Repository
@AllArgsConstructor
public class ProfileAvatarImpl implements ProfileAvatarDao {

    private final RestTemplate restTemplate;


    @SneakyThrows
    @Override
    public <T> ResponseEntity<T> performAvatarOperation(MultipartFile file, Integer id, String profileIdentification, String uuid, Boolean active, String endpoint, HttpMethod httpMethod, Class<T> responseType) {

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", file == null ? null : new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            });
            body.add("id", id);
            body.add("profileIdentification", profileIdentification);
            body.add("uuid", uuid);
            body.add("active", active);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<T> responseEntity = restTemplate.exchange(
                    endpoint,
                    httpMethod,
                    requestEntity,
                    responseType
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity;
            } else {
                return ResponseEntity.badRequest().build();
            }

    }
}
