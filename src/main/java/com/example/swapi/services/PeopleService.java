package com.example.swapi.services;

import com.example.swapi.dto.PeopleResults;
import com.example.swapi.dto.PeopleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    private final SwapiHttpService swapi;
    private final ObjectMapper objectMapper;

    @Autowired
    public PeopleService(SwapiHttpService swapi, ObjectMapper objectMapper) {
        this.swapi = swapi;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public List<PeopleDTO> getAllPeople() {
        String response = swapi.sendRequest("people");
        PeopleResults peopleResults = objectMapper.readValue(response, PeopleResults.class);

        return new ArrayList<>(peopleResults.getResults());
    }

    @SneakyThrows
    public PeopleDTO getPeopleById(String id) {
        String response = swapi.sendRequest("people/" + id);

        return objectMapper.readValue(response, PeopleDTO.class);
    }

}
