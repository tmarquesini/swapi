package com.example.swapi.services;

import com.example.swapi.models.User;
import com.example.swapi.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    public User findByToken(String token) {
        return usersRepository.findByToken(token);
    }

    public User saveUser(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return usersRepository.save(user);
    }

}
