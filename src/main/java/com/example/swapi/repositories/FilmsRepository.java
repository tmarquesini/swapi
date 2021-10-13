package com.example.swapi.repositories;

import com.example.swapi.services.SwapiService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmsRepository {

    private final SwapiService swapiService;

    @Autowired
    public FilmsRepository(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    public JsonObject getAllFilms() {
        return swapiService.get("films");
    }

    public JsonObject getFilmById(String id) {
        return swapiService.get("films/" + id);
    }

}
