package com.example.swapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmDTO {

    @JsonProperty("title")
    private String titulo;
    @JsonProperty("episode_id")
    private String id_do_episodio;
    @JsonProperty("opening_crawl")
    private String texto_de_abertura;
    @JsonProperty("release_date")
    private String data_de_lancamento;
    @JsonProperty("producer")
    private String produtor;
    @JsonProperty("director")
    private String diretor;
    @JsonProperty("url")
    private String url;
    @JsonProperty("characters")
    private Set<String> personagens = new HashSet<>();
    @JsonProperty("planets")
    private Set<String> planetas = new HashSet<>();
    @JsonProperty("species")
    private Set<String> especies = new HashSet<>();
    @JsonProperty("starships")
    private Set<String> espaconaves = new HashSet<>();
    @JsonProperty("vehicles")
    private Set<String> veiculos = new HashSet<>();

}
