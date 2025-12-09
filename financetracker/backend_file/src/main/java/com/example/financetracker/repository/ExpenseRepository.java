package com.example.financetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.financetracker.model.Expense;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findByUserId(String userId);
    List<Expense> findByUserIdAndDateBetween(String userId, LocalDate start, LocalDate end);
}
