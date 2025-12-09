package com.example.financetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.financetracker.model.BudgetAllocation;
import java.util.List;

public interface BudgetAllocationRepository extends MongoRepository<BudgetAllocation, String> {
    List<BudgetAllocation> findByUserId(String userId);
}
