package com.example.swapi.services;

import com.example.swapi.dto.FilmsResults;
import com.example.swapi.dto.FilmDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmsService {

    private final SwapiHttpService swapi;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public List<FilmDTO> getAllFilms() {
        String response = swapi.sendRequest("films");
        FilmsResults filmsResults = objectMapper.readValue(response, FilmsResults.class);

        return new ArrayList<>(filmsResults.getResults());
    }

    @SneakyThrows
    public FilmDTO getFilmById(String id) {
        String response = swapi.sendRequest("films/" + id);

        return objectMapper.readValue(response, FilmDTO.class);
    }

}
