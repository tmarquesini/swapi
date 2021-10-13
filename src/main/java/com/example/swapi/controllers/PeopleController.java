package com.example.swapi.controllers;

import com.example.swapi.dto.PeopleDTO;
import com.example.swapi.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("populacao")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("")
    public List<PeopleDTO> getAllFilms() {
        return peopleService.getAllPeople();
    }

    @GetMapping("{id}")
    public PeopleDTO getFilmById(@PathVariable("id") String id) {
        return peopleService.getPeopleById(id);
    }

}
