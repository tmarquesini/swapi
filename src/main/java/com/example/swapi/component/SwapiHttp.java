package com.example.swapi.component;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SwapiHttp {

    private final RestTemplate restTemplate;

    public SwapiHttp() {
        this.restTemplate = new RestTemplate();
    }

    public String sendRequest(String endpoint) {
        String baseUrl = "https://swapi.dev/api/";
        return restTemplate.getForObject(baseUrl + endpoint, String.class);
    }

}
