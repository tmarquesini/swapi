package com.example.swapi.services;

import com.example.swapi.dto.PlanetResults;
import com.example.swapi.dto.PlanetDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlanetsService {

    private final SwapiHttpService swapi;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public List<PlanetDTO> getAllPlanets() {
        String response = swapi.sendRequest("planets");
        PlanetResults planetResults = objectMapper.readValue(response, PlanetResults.class);

        return new ArrayList<>(planetResults.getResults());
    }

    @SneakyThrows
    public PlanetDTO getPlanetById(String id) {
        String response = swapi.sendRequest("planets/" + id);

        return objectMapper.readValue(response, PlanetDTO.class);
    }

}
