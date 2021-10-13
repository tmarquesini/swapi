package com.example.swapi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiHttpService {

    private final RestTemplate restTemplate;

    public SwapiHttpService() {
        this.restTemplate = new RestTemplate();
    }

    public String sendRequest(String endpoint) {
        String baseUrl = "https://swapi.dev/api/";
        return restTemplate.getForObject(baseUrl + endpoint, String.class);
    }

}
