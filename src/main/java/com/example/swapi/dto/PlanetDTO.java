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
public class PlanetDTO {

    @JsonProperty("name")
    private String nome;
    @JsonProperty("population")
    private String populacao;
    @JsonProperty("climate")
    private String clima;
    @JsonProperty("gravity")
    private String gravidade;
    @JsonProperty("diameter")
    private String diametro;
    @JsonProperty("orbital_period")
    private String periodo_orital;
    @JsonProperty("rotation_period")
    private String periodo_rotacao;
    @JsonProperty("surface_water")
    private String agua_na_superficie;
    @JsonProperty("terrain")
    private String terreno;
    @JsonProperty("url")
    private String url;
    @JsonProperty("films")
    private Set<String> filmes = new HashSet<>();
    @JsonProperty("residents")
    private Set<String> residentes = new HashSet<>();

}
