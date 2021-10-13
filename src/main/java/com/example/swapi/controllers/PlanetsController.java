package com.example.swapi.controllers;

import com.example.swapi.repositories.PlanetsRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planets")
public class PlanetsController {

    private final PlanetsRepository planetsService;

    @Autowired
    public PlanetsController(PlanetsRepository peopleService) {
        this.planetsService = peopleService;
    }

    @GetMapping("")
    public JsonObject getAllFilms() {
        return planetsService.getAllPlanets();
    }

    @GetMapping("{id}")
    public JsonObject getFilmById(@PathVariable("id") String id) {
        return planetsService.getPlanetById(id);
    }

}
