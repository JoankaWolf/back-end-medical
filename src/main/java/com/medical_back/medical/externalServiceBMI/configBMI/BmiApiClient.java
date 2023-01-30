package com.medical_back.medical.externalServiceBMI.configBMI;

import com.medical_back.medical.externalServiceBMI.dtoBMI.BmiResponse;
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
public class BmiApiClient {

    private final RestTemplate restTemplate;
    private final BmiConfig bmiConfig;
    private static final String KEY = "X-RapidAPI-Key";
    private static final String HOST = "X-RapidAPI-Host";


    private HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(KEY, bmiConfig.getBmiAppKey());
        headers.set(HOST, bmiConfig.getBmiHost());
        return headers;
    }

    private URI makeURLBmi(int age, int weight, int height) {
        return UriComponentsBuilder
                .fromHttpUrl(bmiConfig.getBmiApiEndpoint() + "/bmi")
                .queryParam("age", age)
                .queryParam("weight", weight)
                .queryParam("height", height)
                .build()
                .encode()
                .toUri();

    }

    public BmiResponse bmiScore(int age, int weight, int height) {
        try {
            HttpEntity<Void> httpEntity = new HttpEntity<>(setHeaders());
            return restTemplate.exchange(makeURLBmi(age, weight, height), HttpMethod.GET, httpEntity, BmiResponse.class).getBody();
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

//    public List<Employee> getListofEmployee()
// {
//    HttpHeaders headers = new HttpHeaders();
//    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//    HttpEntity<String> entity = new HttpEntity<String>(headers);
//    ResponseEntity<List<Employee>> response = restTemplate.exchange("http://hello-server/rest/employees",
//    HttpMethod.GET,entity, new ParameterizedTypeReference<List<Employee>>() {});
//    return response.getBody(); //this returns List of Employee
//  }
}

