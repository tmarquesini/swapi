package com.example.swapi.repositories;

import com.example.swapi.services.SwapiService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleRepository {

    private final SwapiService swapiService;

    @Autowired
    public PeopleRepository(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    public JsonObject getAllPeople() {
        return swapiService.get("people");
    }

    public JsonObject getPeopleById(String id) {
        return swapiService.get("people/" + id);
    }

}
