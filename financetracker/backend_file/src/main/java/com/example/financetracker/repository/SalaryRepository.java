package com.example.financetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.financetracker.model.Salary;

public interface SalaryRepository extends MongoRepository<Salary, String> {
    Salary findByUserId(String userId);
}
