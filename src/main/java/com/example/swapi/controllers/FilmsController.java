package com.example.swapi.controllers;

import com.example.swapi.repositories.FilmsRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("films")
public class FilmsController {

    private final FilmsRepository filmsService;

    @Autowired
    public FilmsController(FilmsRepository filmsService) {
        this.filmsService = filmsService;
    }

    @GetMapping("")
    public JsonObject getAllFilms() {
        return filmsService.getAllFilms();
    }

    @GetMapping("{id}")
    public JsonObject getFilmById(@PathVariable("id") String id) {
        return filmsService.getFilmById(id);
    }

}
