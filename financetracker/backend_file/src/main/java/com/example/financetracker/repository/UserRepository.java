package com.example.financetracker.repository;

import java.util.Optional;   // for Optional
import org.springframework.stereotype.Repository; // for @Repository
import org.springframework.data.mongodb.repository.MongoRepository; // for MongoRepository
import com.example.financetracker.model.User; // your User class

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.financetracker.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
