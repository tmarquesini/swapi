package com.example.swapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiHttpService {

    private final RestTemplate restTemplate;

    @Value("${swapi.base_url}")
    private String baseUrl;

    public SwapiHttpService() {
        this.restTemplate = new RestTemplate();
    }

    public String sendRequest(String endpoint) {
        return restTemplate.getForObject(baseUrl + endpoint, String.class);
    }

}
