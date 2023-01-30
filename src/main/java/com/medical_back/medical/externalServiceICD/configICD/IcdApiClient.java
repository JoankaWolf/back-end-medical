package com.medical_back.medical.externalServiceICD.configICD;

import com.medical_back.medical.externalServiceICD.dtoICD.ICDRootDataDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
@Slf4j
@Component
@RequiredArgsConstructor
@Getter
public class IcdApiClient {

    private final RestTemplate restTemplate;
    private final ICDConfig icdConfig;
    private static final String KEY = "X-RapidAPI-Key";
    private static final String HOST = "X-RapidAPI-Host";
    private static final String AUTHORIZATION = "Authorization";



    private HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(AUTHORIZATION, icdConfig.getIcdAuthorization());
        headers.set(KEY, icdConfig.getIcdAppKey());
        headers.set(HOST, icdConfig.getIcdHost());
        return headers;
    }

    private URI makeURLIcd(String disease) {
        return UriComponentsBuilder
                .fromHttpUrl(icdConfig.getIcdApiEndpoint() + disease)
                .build()
                .encode()
                .toUri();
    }



    public ICDRootDataDto ICD(String disease) {
        try {
            HttpEntity<Void> httpEntity = new HttpEntity<>(setHeaders());
            return restTemplate.exchange(makeURLIcd(disease), HttpMethod.GET,httpEntity, ICDRootDataDto.class).getBody();
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
