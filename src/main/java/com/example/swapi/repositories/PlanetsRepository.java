package com.example.swapi.repositories;

import com.example.swapi.services.SwapiService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetsRepository {

    private final SwapiService swapiService;

    @Autowired
    public PlanetsRepository(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    public JsonObject getAllPlanets() {
        return swapiService.get("planets");
    }

    public JsonObject getPlanetById(String id) {
        return swapiService.get("planets/" + id);
    }

}
