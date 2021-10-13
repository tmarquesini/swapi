package com.example.swapi.controllers;

import com.example.swapi.dto.PlanetDTO;
import com.example.swapi.services.PlanetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("planetas")
public class PlanetsController {

    private final PlanetsService planetsService;

    @Autowired
    public PlanetsController(PlanetsService peopleService) {
        this.planetsService = peopleService;
    }

    @GetMapping("")
    public List<PlanetDTO> getAllFilms() {
        return planetsService.getAllPlanets();
    }

    @GetMapping("{id}")
    public PlanetDTO getFilmById(@PathVariable("id") String id) {
        return planetsService.getPlanetById(id);
    }

}
