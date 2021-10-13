package com.example.swapi.controllers;

import com.example.swapi.repositories.PeopleRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("people")
public class PeopleController {

    private final PeopleRepository peopleService;

    @Autowired
    public PeopleController(PeopleRepository peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("")
    public JsonObject getAllFilms() {
        return peopleService.getAllPeople();
    }

    @GetMapping("{id}")
    public JsonObject getFilmById(@PathVariable("id") String id) {
        return peopleService.getPeopleById(id);
    }

}
