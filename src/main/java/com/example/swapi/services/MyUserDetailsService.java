package com.example.swapi.services;

import com.example.swapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UsersService usersService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersService.findByUsername(username);
         if (null == user) {
             throw new UsernameNotFoundException("User not found");
         }
        return user;
    }

}
