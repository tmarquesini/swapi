package com.example.swapi.controllers;

import com.example.swapi.dto.FilmDTO;
import com.example.swapi.services.FilmsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filmes")
@AllArgsConstructor
public class FilmsController {

    private final FilmsService filmsService;

    @GetMapping("")
    public List<FilmDTO> getAllFilms() {
        return filmsService.getAllFilms();
    }

    @GetMapping("{id}")
    public FilmDTO getFilmById(@PathVariable("id") String id) {
        return filmsService.getFilmById(id);
    }

}
