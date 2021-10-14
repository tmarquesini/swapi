package com.example.swapi.repositories;

import com.example.swapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByToken(String token);

}
