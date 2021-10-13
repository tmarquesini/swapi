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
public class PeopleDTO {

    @JsonProperty("name")
    private String nome;
    @JsonProperty("gender")
    private String genero;
    @JsonProperty("homeworld")
    private String planeta_natal;
    @JsonProperty("birth_year")
    private String ano_de_nascimento;
    @JsonProperty("eye_color")
    private String cor_dos_olhos;
    @JsonProperty("hair_color")
    private String cod_do_cabelo;
    @JsonProperty("skin_color")
    private String cod_da_pele;
    @JsonProperty("height")
    private String altura;
    @JsonProperty("mass")
    private String massa;
    @JsonProperty("url")
    private String url;
    @JsonProperty("films")
    private Set<String> filmes = new HashSet<>();
    @JsonProperty("species")
    private Set<String> especies = new HashSet<>();
    @JsonProperty("starships")
    private Set<String> aeronaves = new HashSet<>();
    @JsonProperty("vehicles")
    private Set<String> veiculos = new HashSet<>();

}
