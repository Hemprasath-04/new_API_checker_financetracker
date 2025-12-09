package com.example.financetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.financetracker.model.Saving;
import java.util.List;

public interface SavingRepository extends MongoRepository<Saving, String> {
    List<Saving> findByUserId(String userId);
}
