package com.example.financetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.financetracker.model.Account;
import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByUserId(String userId);
}
