package com.example.transportrest.repository;


import com.example.transportrest.entiry.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, Integer> {

    User findByLogin(String login);

}
