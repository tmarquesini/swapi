package com.example.swapi.controllers;

import com.example.swapi.exceptions.UserAlreadyExistsException;
import com.example.swapi.models.User;
import com.example.swapi.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("register")
    public ResponseEntity<User> create(@RequestBody User user) {
        User existingUser = usersService.findByUsername(user.getUsername());
        if (null != existingUser) {
            throw new UserAlreadyExistsException();
        }
        User newUser = usersService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
