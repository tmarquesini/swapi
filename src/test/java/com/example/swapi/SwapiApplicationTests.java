package com.example.swapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.swapi.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SwapiApplicationTests {

    @Autowired
    private FilmsController filmsController;

    @Autowired
    private PeopleController peopleController;

    @Autowired
    private PlanetsController planetsController;

    @Autowired
    private UsersController usersController;

    @Autowired
    private AuthenticationController authenticationController;

    @Test
    void contextLoads() throws Exception {
        assertThat(filmsController).isNotNull();
        assertThat(peopleController).isNotNull();
        assertThat(planetsController).isNotNull();
        assertThat(usersController).isNotNull();
        assertThat(authenticationController).isNotNull();
    }

}
