package com.example.swapi.controllers;

import com.example.swapi.dto.LoginDTO;
import com.example.swapi.dto.TokenDTO;
import com.example.swapi.models.User;
import com.example.swapi.services.TokenService;
import com.example.swapi.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsersService usersService;

    @PostMapping("auth")
    public ResponseEntity<TokenDTO> auth(@RequestBody LoginDTO loginDTO) {
        User user = usersService.findByUsername(loginDTO.getUsername());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.generateToken(authentication);
        return ResponseEntity.ok(TokenDTO.builder().type("Bearer").token(token).build());
    }

}
