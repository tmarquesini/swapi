package com.example.swapi.controllers;

import com.example.swapi.dto.PasswordDTO;
import com.example.swapi.exceptions.UserAlreadyExistsException;
import com.example.swapi.models.User;
import com.example.swapi.services.TokenService;
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
    private final TokenService tokenService;

    @PostMapping("register")
    public ResponseEntity<User> create(@RequestBody User user) {
        User existingUser = usersService.findByUsername(user.getUsername());
        if (null != existingUser) {
            throw new UserAlreadyExistsException();
        }
        User newUser = usersService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("password")
    public ResponseEntity<User> update(@RequestBody PasswordDTO passwordDTO, @RequestHeader("Authorization") String authorization) {
        String token = authorization.substring(7);
        String username = tokenService.getTokenUsername(token);
        User user = usersService.findByUsername(username);
        user.setPassword(passwordDTO.getPassword());
        return new ResponseEntity<>(usersService.saveUser(user), HttpStatus.OK);
    }

}
